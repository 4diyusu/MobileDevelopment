package com.example.finalproject001.screen

import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.net.Uri
import android.provider.OpenableColumns
import android.webkit.MimeTypeMap
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.core.content.FileProvider
import androidx.navigation.NavController
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import com.example.finalproject001.R
import com.example.finalproject001.Routes


@Composable
fun FilePickerScreen(modifier: Modifier, navController: NavController) {
    val context = LocalContext.current
    var selectedFileUri by remember { mutableStateOf<Uri?>(null) }
    var selectedFileName by remember { mutableStateOf<String?>(null) }
    var fileIconRes by remember { mutableStateOf<Int>(R.drawable.ic_default) }

    // File Picker Launcher
    val pickFileLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        selectedFileUri = uri
        selectedFileName = uri?.let { getFileName(context, it) }
        fileIconRes = uri?.let { getFileIcon(context, it) } ?: R.drawable.ic_default
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF2D3536)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "NOTE:", fontStyle = FontStyle.Normal, fontWeight = FontWeight.SemiBold, color = Color.White)
        Text(text = "-Please select proper file.", fontStyle = FontStyle.Normal, color = Color.White)
        Text(text = "-Do not forget to inform the clerk of your print details.", fontStyle = FontStyle.Normal, color = Color.White)
        Text(text = "-You may exit the page after sending.", fontStyle = FontStyle.Normal, color = Color.White)

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { pickFileLauncher.launch("*/*") },
            Modifier.width(140.dp)) {
            Text("Pick a File", fontStyle = FontStyle.Normal)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            navController.navigate(Routes.mainmenuScreen)
        }, Modifier.width(140.dp)){
            Text(text = "Cancel", fontStyle = FontStyle.Normal)
        }

        Spacer(modifier = Modifier.height(16.dp))

        selectedFileUri?.let {
            Image(
                painter = painterResource(id = fileIconRes),
                contentDescription = "File Icon",
                modifier = Modifier.size(48.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Selected File: ${selectedFileName ?: "Unknown"}", maxLines = 1)
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = { shareFile(context, it) }) {
                Text("Share File")
            }
        }
    }
}

// Function to Get File Name from URI
fun getFileName(context: Context, uri: Uri): String? {
    var fileName: String? = null
    val cursor: Cursor? = context.contentResolver.query(uri, null, null, null, null)
    cursor?.use {
        if (it.moveToFirst()) {
            val nameIndex = it.getColumnIndex(OpenableColumns.DISPLAY_NAME)
            if (nameIndex != -1) {
                fileName = it.getString(nameIndex)
            }
        }
    }
    return fileName
}

// Function to Get File Icon Based on Type
fun getFileIcon(context: Context, uri: Uri): Int {
    val mimeType = context.contentResolver.getType(uri) ?: return R.drawable.ic_default
    return when {
        mimeType.startsWith("application/pdf") -> R.drawable.ic_default
        mimeType.startsWith("application/msword") || mimeType.startsWith("application/vnd.openxmlformats-officedocument.wordprocessingml") -> R.drawable.ic_default
        mimeType.startsWith("application/vnd.ms-excel") || mimeType.startsWith("application/vnd.openxmlformats-officedocument.spreadsheetml") -> R.drawable.ic_default
        else -> R.drawable.ic_default
    }
}

// Function to Share the Selected File
fun shareFile(context: Context, uri: Uri) {
    val fileName = getFileName(context, uri) ?: "shared_file"

    // Create a new file in the app’s cache directory
    val cacheDir = File(context.cacheDir, "shared_files")
    if (!cacheDir.exists()) cacheDir.mkdirs()

    val file = File(cacheDir, fileName)

    // Copy the file contents to cache storage
    try {
        val inputStream: InputStream? = context.contentResolver.openInputStream(uri)
        val outputStream = FileOutputStream(file)
        inputStream?.copyTo(outputStream)
        inputStream?.close()
        outputStream.close()
    } catch (e: Exception) {
        e.printStackTrace()
        return
    }

    // Generate a content URI with FileProvider
    val fileUri: Uri = FileProvider.getUriForFile(context, "${context.packageName}.provider", file)

    // Create and launch the share intent
    val shareIntent = Intent(Intent.ACTION_SEND).apply {
        type = context.contentResolver.getType(uri) ?: "*/*"
        putExtra(Intent.EXTRA_STREAM, fileUri)
        addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
    }
    context.startActivity(Intent.createChooser(shareIntent, "Share file via"))
}
