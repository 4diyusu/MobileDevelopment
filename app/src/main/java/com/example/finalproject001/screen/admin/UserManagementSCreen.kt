package com.example.finalproject001.screen.admin

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.finalproject001.data.User
import com.example.finalproject001.viewmodel.AdminViewModel

@Composable
fun UsersManagementScreen(navController: NavController, viewModel: AdminViewModel = viewModel()) {
    val users by viewModel.users.observeAsState(emptyList())
    val scrollState = rememberLazyListState()

    LaunchedEffect(Unit) {
        viewModel.fetchUsers()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "USER ACCOUNTS", fontSize = 28.sp, fontWeight = FontWeight.Bold)

        LazyColumn(
            state = scrollState,
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(bottom = 56.dp)
        ) {
            items(users) { user ->
                UserItem(
                    user = user,
                    onDelete = { viewModel.deleteUser(user.id) },
                    onUpdate = { updatedUser -> viewModel.updateUser(user.id, updatedUser) }
                )
            }
        }
    }
}


@Composable
fun UserItem(user: User, onDelete: () -> Unit, onUpdate: (User) -> Unit) {
    var showDeleteDialog by remember { mutableStateOf(false) }
    var showEditDialog by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "${user.firstName} ${user.lastName}", style = MaterialTheme.typography.headlineSmall)
            Text(text = user.email, style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(8.dp))

            Row {
                Button(onClick = { showEditDialog = true }) {
                    Text("Edit")
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(onClick = { showDeleteDialog = true }, colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)) {
                    Text("Delete")
                }
            }
        }
    }

    if (showDeleteDialog) {
        DeleteUserDialog(
            user = user,
            onConfirm = {
                onDelete()
                showDeleteDialog = false
            },
            onDismiss = { showDeleteDialog = false }
        )
    }

    if (showEditDialog) {
        EditUserDialog(
            user = user,
            onUpdate = { updatedUser ->
                onUpdate(updatedUser)
                showEditDialog = false
            },
            onDismiss = { showEditDialog = false }
        )
    }
}

@Composable
fun DeleteUserDialog(user: User, onConfirm: () -> Unit, onDismiss: () -> Unit) {
    val context = LocalContext.current

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Delete User") },
        text = { Text("Are you sure you want to delete ${user.firstName} ${user.lastName}?") },
        confirmButton = {
            Button(onClick = onConfirm) {
                Text("Delete")
                Toast.makeText(context, "User Deleted!", Toast.LENGTH_SHORT).show()
            }
        },
        dismissButton = {
            Button(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    )
}

@Composable
fun EditUserDialog(user: User, onUpdate: (User) -> Unit, onDismiss: () -> Unit) {
    val context = LocalContext.current

    var firstName by remember { mutableStateOf(user.firstName) }
    var lastName by remember { mutableStateOf(user.lastName) }
    var email by remember { mutableStateOf(user.email) }
    var username by remember { mutableStateOf(user.username) }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Edit User") },
        text = {
            Column {
                OutlinedTextField(value = firstName, onValueChange = { firstName = it }, label = { Text("First Name") })
                OutlinedTextField(value = lastName, onValueChange = { lastName = it }, label = { Text("Last Name") })
                OutlinedTextField(value = email, onValueChange = { email = it }, label = { Text("Email") })
                OutlinedTextField(value = username, onValueChange = { username = it }, label = { Text("Username") })
            }
        },
        confirmButton = {
            Button(onClick = {
                onUpdate(User(user.id, firstName, lastName, email, username))
            }) {
                Text("Update")
                Toast.makeText(context, "Account Updated!", Toast.LENGTH_SHORT).show()
            }
        },
        dismissButton = {
            Button(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    )
}
