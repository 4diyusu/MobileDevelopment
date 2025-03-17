package com.example.finalproject001.data

import com.example.finalproject001.R

/*
object DataProvider{
    val product =
        ProductData(1, "CASIO FX-991ES", 1385.00,
                "New functions:\n" +
                "\n" +
                "New equation mode\n" +
                "-Random integers\n" +
                "\n" +
                "\n" +
                "Standard functions:\n" +
                "\n" +
                "Fraction calculations\n" +
                "Combination and permutation\n" +
                "Statistics (List-based STAT data editor, standard deviation, regression analysis)\n" +
                "9 variables\n" +
                "Table function\n" +
                "Comes with new slide-on hard case\n" +
                "\n" +
                "Number of Functions : 417\n" +
                "With Natural Textbook Display\n" +
                "Digits: 10 + 2 digits (10-digit mantissa + 2-digit exponential display)\n" +
                "Dot Matrix Display\n" +
                "Multi-replay\n" +
                "Solar & Battery",
            R.drawable.scientific_calculator_casiofx991es)

    val productList = listOf(
        product,
        ProductData(2, "CASIO FX-570MS", 1105.00,
                "401 Functions / Dot Matrix Display\n" +
                "2-Line Display / 10+2 Digits / Plastic Keys\n" +
                "Multi-replay function , Matrix calculations , Equation calculations , Vector calculations , Differential calculations , SOLVE function\n" +
                "Fraction calculations\n" +
                "Combination and permutation\n" +
                "Statistics (STAT-data editor, Standard deviation, Regression analysis)\n" +
                "9 variable memories\n" +
                "Regular percentage calculations.\n" +
                "S-V.P.A.M. (Super Visually Perfect Algebraic Method)\n" +
                "STAT-data editor: Back-step viewing and editing of input data.\n" +
                "Basic Mathematical Functions: Trigonometric, Exponential logarithmic, etc.\n" +
                "Basic Statistics: Standard statistics functions such as Mean, SUM, Standard Deviation, and Regression\n" +
                "Metric conversion function\n" +
                "Button-type battery (LR44)",
            R.drawable.scientific_calculator_casiofx570ms),
        ProductData(3, "CASIO FX-82MS", 610.00,
                "Fraction calculations\n" +
                "Combination and permutation\n" +
                "Statistics (STAT-data editor, Standard deviation, Regression analysis)\n" +
                "9 variables\n" +
                "Comes with slide-on hard case\n" +
                "S-V.P.A.M. (Super Visually Perfect Algebraic Method)\n" +
                "All the features of the existing V.P.A.M. series plus a new 2-line display and a useful Replay function. All this helps to make mathematics easier to use and easier to understand than ever before.\n" +
                "Basic Mathematical Functions: Trigonometric, Exponential logarithmic, etc.\n" +
                "STAT-data editor: Back-step viewing and editing of input data.",
            R.drawable.scientific_calculator_casiofx82ms),
        ProductData(4, "MONGOL 3 Pencil Exam-Set", 74.00,
                "Mongol Pencils are sturdy, hexagonal/triangular shaped, made with premium wood and high-quality graphite for extra smooth and readable performance.\n" +
                "\n" +
                "Mongol Exam set comes with:\n" +
                " - 3pcs Mongol Pencil #3\n" +
                " - 1pc Eraser\n" +
                " - 1pc Sharpener",
            R.drawable.pencil_mongol3_examset),
        ProductData(5, "MONGOL 3 Pencil 3s", 32.00,
                "Mongol Regular Pencils are sturdy, hexagonal/triangular in shape, made with premium wood and high-quality graphite for extra smooth and readable performance.\n" +
                " \n" +
                "Sharpens to a fine, exact point\n" +
                "Attr: Pencil #3 with black lead\n" +
                "Color: Yellow\n" +
                "Packaging Size: 3 pencils per pack",
            R.drawable.pencil_mongol3_3s),
        ProductData(6, "ARTLINE 0.1", 80.00,
                "The Artline DRAWING SYSTEM boasts of its highly waterproof ink and a rich variety of pen nibs. The new colours are suitable for underlining and outlining when drawing illustrations.\n" +
                "\n" +
                "Friction-proof nib enables you to draw a consistent writing width.\n" +
                "Metal reinforced collar nib is suitable for ruler and template work without causing any nib damage.\n" +
                "Water-resistant feature assured with top quality pigment ink.\n" +
                "Acid and Xylene-free\n" +
                "Cap and end plug conform to British Standard BS7272-1.2\n" +
                "Pen Tip Size: 0.1 mm\n" +
                "Ink Color: Black\n" +
                "Packaging Size: 1 pc.",
            R.drawable.ballpen_artline_01),
        ProductData(7, "ARTLINE 0.4", 80.00,
                "The Artline DRAWING SYSTEM boasts of its highly waterproof ink and a rich variety of pen nibs. The new colours are suitable for underlining and outlining when drawing illustrations.\n" +
                "\n" +
                "Friction-proof nib enables you to draw a consistent writing width.\n" +
                "Metal reinforced collar nib is suitable for ruler and template work without causing any nib damage.\n" +
                "Water-resistant feature assured with top quality pigment ink.\n" +
                "Acid and Xylene-free\n" +
                "Cap and end plug conform to British Standard BS7272-1.2\n" +
                "Pen Tip Size: 0.4 mm\n" +
                "Ink Color: Black\n" +
                "Packaging Size: 1 pc.",
            R.drawable.ballpen_artline_04),
        ProductData(8, "ARTLINE 0.5", 80.00,
                "The Artline DRAWING SYSTEM boasts of its highly waterproof ink and a rich variety of pen nibs. The new colours are suitable for underlining and outlining when drawing illustrations.\n" +
                "\n" +
                "Friction-proof nib enables you to draw a consistent writing width.\n" +
                "Metal reinforced collar nib is suitable for ruler and template work without causing any nib damage.\n" +
                "Water-resistant feature assured with top quality pigment ink.\n" +
                "Acid and Xylene-free\n" +
                "Cap and end plug conform to British Standard BS7272-1.2\n" +
                "Pen Tip Size: 0.5 mm\n" +
                "Ink Color: Black\n" +
                "Packaging Size: 1 pc.",
            R.drawable.ballpen_artline_05),
        ProductData(9, "ARTLINE 0.8", 80.00,
                "The Artline DRAWING SYSTEM boasts of its highly waterproof ink and a rich variety of pen nibs. The new colours are suitable for underlining and outlining when drawing illustrations.\n" +
                "\n" +
                "Friction-proof nib enables you to draw a consistent writing width.\n" +
                "Metal reinforced collar nib is suitable for ruler and template work without causing any nib damage.\n" +
                "Water-resistant feature assured with top quality pigment ink.\n" +
                "Acid and Xylene-free\n" +
                "Cap and end plug conform to British Standard BS7272-1.2\n" +
                "Pen Tip Size: 0.8 mm\n" +
                "Ink Color: Black\n" +
                "Packaging Size: 1 pc.",
            R.drawable.ballpen_artline_08),
        ProductData(10, "DONG-A Ball Point Pen Gel Black", 23.00,
                "Its permanent gel ink performs excellently for ultra-smooth writing. \n" +
                "\n" +
                "Pen tip size: 0.5 mm\n" +
                "Color: Black\n" +
                "Packaging Size: 1 pc",
            R.drawable.ballpen_donga_gel_black),
        ProductData(11, "DONG-A Ball Point Pen Gel Blue", 23.00,
                "Its permanent gel ink performs excellently for ultra-smooth writing. \n" +
                "\n" +
                "Pen tip size: 0.5 mm\n" +
                "Color: Blue\n" +
                "Packaging Size: 1 pc",
            R.drawable.ballpen_donga_gel_blue),
        ProductData(12, "DONG-A Ball Point Pen Gel Red", 23.00,
                "Its permanent gel ink performs excellently for ultra-smooth writing. \n" +
                "\n" +
                "Pen tip size: 0.5 mm\n" +
                "Color: Red\n" +
                "Packaging Size: 1 pc",
            R.drawable.ballpen_donga_gel_red),
        ProductData(13, "DONG-A Retractable Ball Point Pen Gel Black", 32.00,
                "Ultra-smooth permanent gel ink for smooth writing performance.\n" +
                "\n" +
                "With patented u-spring technology\n" +
                "Retractable gel pen\n" +
                "Pen Tip Size: 0.5 mm\n" +
                "Color: Black\n" +
                "Packaging Size: 1 pc.",
            R.drawable.ballpen_donga_gel_rblack),
        ProductData(14, "DONG-A Retractable Ball Point Pen Gel Blue", 32.00,
                "Ultra-smooth permanent gel ink for smooth writing performance.\n" +
                "\n" +
                "With patented u-spring technology\n" +
                "Retractable gel pen\n" +
                "Pen Tip Size: 0.5 mm\n" +
                "Color: Blue\n" +
                "Packaging Size: 1 pc.",
            R.drawable.ballpen_donga_gel_rblue),
        ProductData(15, "PILOT G-TEC 0.3 Black", 80.00,
                "The G-Tec-C Gel Ink Rolling Ball Pen takes artistry to the next level. Equipped with fine point in various pen tip sizes, the G-Tec-C eliminates feathering and always provides razor precision.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Perfect for extremely fine, intricate and colorful writing\n" +
                "Eliminates feathering and smearing\n" +
                "The only pen with smear-proof bio-polymer ink\n" +
                "Textured grip for perfect control\n" +
                "Model: G-TEC-C3\n" +
                "Pen Tip Size: 0.3 mm\n" +
                "Color: Black",
            R.drawable.ballpen_gtec_03_black),
        ProductData(16, "PILOT G-TEC 0.3 Blue", 80.00, "The G-Tec-C Gel Ink Rolling Ball Pen takes artistry to the next level. Equipped with fine point in various pen tip sizes, the G-Tec-C eliminates feathering and always provides razor precision.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Perfect for extremely fine, intricate and colorful writing\n" +
                "Eliminates feathering and smearing\n" +
                "The only pen with smear-proof bio-polymer ink\n" +
                "Textured grip for perfect control\n" +
                "Model: G-TEC-C3\n" +
                "Pen Tip Size: 0.3 mm\n" +
                "Color: Blue",
            R.drawable.ballpen_gtec_03_blue),
        ProductData(17, "HBW 2000 Black", 6.00,
                "Perfectly balance designed high quality ballpoint pen\n" +
                "Smooth writing with super fine point best for school & office use\n" +
                "Model: HBW 2000\n" +
                "Pen Tip Size: 0.5 mm\n" +
                "Color: Black",
            R.drawable.ballpen_hbv_black),
        ProductData(18, "HBW 2000 Blue", 6.00,
                "Perfectly balance designed high quality ballpoint pen\n" +
                "Smooth writing with super fine point best for school & office use\n" +
                "Model: HBW 2000\n" +
                "Pen Tip Size: 0.5 mm\n" +
                "Color: Blue",
            R.drawable.ballpen_hbv_blue),
        ProductData(19, "HBW 2000 Red", 6.00,
                "Perfectly balance designed high quality ballpoint pen\n" +
                "Smooth writing with super fine point best for school & office use\n" +
                "Model: HBW 2000\n" +
                "Pen Tip Size: 0.5 mm\n" +
                "Color: Red",
            R.drawable.ballpen_hbv_red),
        ProductData(20, "PANDA Classique Black", 7.00,
                "Quality and affordable Panda Ballpen\n" +
                "Model: Classique\n" +
                "Pen Tip Size: 0.7 mm\n" +
                "Color: Black\n" +
                "Packaging Size: 1 pc",
            R.drawable.ballpen_panda_07_black),
        ProductData(21, "PANDA Classique Blue", 7.00,
                "Quality and affordable Panda Ballpen\n" +
                "Model: Classique\n" +
                "Pen Tip Size: 0.7 mm\n" +
                "Color: Blue\n" +
                "Packaging Size: 1 pc",
            R.drawable.ballpen_panda_07_blue),
        ProductData(22, "PANDA Classique Red", 7.00,
                "Quality and affordable Panda Ballpen\n" +
                "Model: Classique\n" +
                "Pen Tip Size: 0.7 mm\n" +
                "Color: Red\n" +
                "Packaging Size: 1 pc",
            R.drawable.ballpen_panda_07_red),
        ProductData(23, "PANDA Crystal Black", 7.00,
                "Quality and affordable Panda Ballpen\n" +
                "Model: Crystal\n" +
                "Pen Tip Size: 0.7 mm\n" +
                "Color: Black\n" +
                "Packaging Size: 1 pc",
            R.drawable.ballpen_panda_07_cblack),
        ProductData(24, "PANDA Crystal Blue", 7.00,
                "Quality and affordable Panda Ballpen\n" +
                "Model: Crystal\n" +
                "Pen Tip Size: 0.7 mm\n" +
                "Color: Blue\n" +
                "Packaging Size: 1 pc",
            R.drawable.ballpen_panda_07_cblue),
        ProductData(25, "PANDA Crystal Red", 7.00,
                "Quality and affordable Panda Ballpen\n" +
                "Model: Crystal\n" +
                "Pen Tip Size: 0.7 mm\n" +
                "Color: Red\n" +
                "Packaging Size: 1 pc",
            R.drawable.ballpen_panda_07_cred),
        ProductData(26, "Energizer Battery C", 250.00,
                "PowerSeal™ Technology is the Energizer innovation that delivers energy you can rely on. Up to 10-year shelf life means you'll always have power when you need it.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Classification: Alkaline\n" +
                "Chemical System: Zinc-Manganese Dioxide (Zn/MnO2)\n" +
                "Designation: ANSI-14A, IEC-LR14\n" +
                "Operating Temp: -18°C to 55°C (0°F to 130°F)\n" +
                "Typical Weight: 66 grams\n" +
                "Typical Volume: 27 cubic centimeters\n" +
                "Shelf Life: 10 years at 21°C\n" +
                "Terminal: Flat Contact\n" +
                "Nominal Voltage: 1.5 volts\n" +
                "Packaging Size: 2 batteries per pack",
            R.drawable.battery_energizer_a),
        ProductData(27, "Energizer Battery AA", 120.00,
                "Designed to protect against damaging leaks for up to 2 years after fully used, and can hold power for up to 10 years in storage.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Attr: E91, AA\n" +
                "Classification: Alkaline battery\n" +
                "Nominal Voltage: 1.5 volts\n" +
                "Typical Weight: 23.0 grams (0.8 oz.)\n" +
                "Typical Volume: 8.1 cubic centimeters (0.5 cubic inch)\n" +
                "Shelf Life: 10 years at 21°C\n" +
                "Terminal: Flat Contact\n" +
                "Packaging Size: 2 batteries per pack",
            R.drawable.battery_energizer_aa),
        ProductData(28, "Energizer Battery AAA", 130.00,
                "Designed to protect against damaging leaks for up to 2 years after fully used, and can hold power for up to 10 years in storage.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Attr: E92, AAA\n" +
                "Classification: Alkaline battery\n" +
                "Nominal voltage: 1.5 volts\n" +
                "Typical Weight: 11.5 grams (0.4 oz.)\n" +
                "Typical Volume: 3.8 cubic centimeters (0.2 cubic inch)\n" +
                "Chemical System: Zinc-Manganese Dioxide (Zn/MnO2)\n" +
                "No added mercury or cadmium\n" +
                "Designation: ANSI-24A, IEC-LR03\n" +
                "Shelf Life: 10 years at 21°C\n" +
                "Terminal: Flat Contact\n" +
                "Packaging Size: 2 batteries per pack",
            R.drawable.battery_energizer_aaa),
        ProductData(29, "Energizer Battery BP1", 210.00,
                "Reliable energy made possible with Energizer's innovative PowerSeal™ Technology. Up to 5-year shelf life - so you'll always have power when you need it.\n" +
                " \n" +
                " \n" +
                "Classification: Alkaline\n" +
                "Chemical System: Zinc-Manganese Dioxide (Zn/MnO2)\n" +
                "Designation: ANSI 1604A, IEC-6LF22 or 6LR61\n" +
                "Operating Temp: -18°C to 55°C\n" +
                "Typical Weight: 45 grams\n" +
                "Typical Volume: 21 cubic centimeters\n" +
                "Shelf Life: 5 years at 21°C\n" +
                "Terminal: Miniature Snap\n" +
                "Nominal Voltage: 9.0 volts\n" +
                "Packaging size: 1 pc per pack",
            R.drawable.battery_energizer_b),
        ProductData(30, "Binder Clips", 5.00,
                "Binder Clips",
            R.drawable.binder_clip),
        ProductData(31, "CASIO DJ-220D", 1340.00,
                "12 digits\n" +
                "Displays up to 150 previous calculation steps.\n" +
                "Automatic calculation of price plus tax, price less tax, discount, selling price, tax amount, discount amount, and margin amount.\n" +
                "Solar & Battery\n" +
                "Key operations are stored in a buffer, so nothing is lost even during high-speed input.\n" +
                "Extra Large display\n" +
                "Plastic keys designed and engineered for easy operation.\n" +
                "Profit margin percent: \" % \" key gives quick access to prices and profits, and also delivers add-ons, discounts, ratios and increase/decrease values.\n" +
                "Displays numbers in four digit separator formats(Type A, Type B, Type C and Indian).\n" +
                "Metal Faceplate stands up to rough treatment.\n" +
                "Big, easy-to-read command signs show your current operation at a glance.",
            R.drawable.calculator_dj220d),
        ProductData(32, "CASIO MS-20UC", 670.00,
                "Mini Desk Type\n" +
                "12 digits\n" +
                "Tax calculation: Automatic calculation of price plus tax, price less tax, discount, selling price, tax amount, discount amount, and margin amount.\n" +
                "Time calculation: Time calculation allows easy input and calculation of hour, minute, and second values.\n" +
                "Solar & Battery\n" +
                "Function command signs: A symbol (+, -, ×, ÷) on the display indicates the status of operation you are currently performing.\n" +
                "Key rollover: Key operations are stored in a buffer, so nothing is lost even during high-speed input.\n" +
                "Extra Large display\n" +
                "Plastic keys: Designed and engineered for easy operation.\n" +
                "Profit margin percent: \" % \" key gives quick access to prices and profits, and also delivers add-ons, discounts, ratios and increase/decrease values.\n" +
                " \n" +
                "\n" +
                "Dimensions (D × W × H) : 149.5×105×22.8mm\n" +
                "Weight : 110g\n" +
                "Color: Black",
            R.drawable.calculator_ms20uc),
        ProductData(33, "Office Warehouse Cartolina Black", 35.00,
                "Ideal for school and art projects\n" +
                "Grammage: 80 gsm\n" +
                "Color: Black\n" +
                "Packaging Size: 3 sheets per roll",
            R.drawable.cartolina_black),
        ProductData(34, "Office Warehouse Cartolina Golden Yellow", 35.00,
                "Ideal for school and art projects\n" +
                "Grammage: 80 gsm\n" +
                "Color: Golden Yellow\n" +
                "Packaging Size: 3 sheets per roll",
            R.drawable.cartolina_goldenyellow),
        ProductData(35, "Office Warehouse Cartolina Grape Violet", 35.00,
                "Ideal for school and art projects\n" +
                "Grammage: 80 gsm\n" +
                "Color: Grape Violet\n" +
                "Packaging Size: 3 sheets per roll",
            R.drawable.cartolina_grapeviolet),
        ProductData(36, "Office Warehouse Cartolina Green", 35.00, "" +
                "Ideal for school and art projects\n" +
                "Grammage: 80 gsm\n" +
                "Color: Green\n" +
                "Packaging Size: 3 sheets per roll",
            R.drawable.cartolina_green),
        ProductData(37, "Office Warehouse Cartolina Lemon Yellow", 35.00,
                "Ideal for school and art projects\n" +
                "Grammage: 80 gsm\n" +
                "Color: Lemon Yellow\n" +
                "Packaging Size: 3 sheets per roll",
            R.drawable.cartolina_lemonyellow),
        ProductData(38, "Office Warehouse Cartolina Orange", 35.00,
                "Ideal for school and art projects\n" +
                "Grammage: 80 gsm\n" +
                "Color: Orange\n" +
                "Packaging Size: 3 sheets per roll",
            R.drawable.cartolina_orange),
        ProductData(39, "Office Warehouse Cartolina Pink", 35.00,
                "Ideal for school and art projects\n" +
                "Grammage: 80 gsm\n" +
                "Color: Pink\n" +
                "Packaging Size: 3 sheets per roll",
            R.drawable.cartolina_pink),
        ProductData(40, "Office Warehouse Cartolina Red", 35.00,
                "Ideal for school and art projects\n" +
                "Grammage: 80 gsm\n" +
                "Color: Red\n" +
                "Packaging Size: 3 sheets per roll",
            R.drawable.cartolina_red),
        ProductData(41, "Office Warehouse Cartolina Royal Blue", 35.00,
                "Ideal for school and art projects\n" +
                "Grammage: 80 gsm\n" +
                "Color: Royal Blue\n" +
                "Packaging Size: 3 sheets per roll",
            R.drawable.cartolina_royalblue),
        ProductData(42, "Office Warehouse Cartolina Sky Blue", 35.00,
                "Ideal for school and art projects\n" +
                "Grammage: 80 gsm\n" +
                "Color: Sky Blue\n" +
                "Packaging Size: 3 sheets per roll",
            R.drawable.cartolina_skyblue),
        ProductData(43, "Office Warehouse Cartolina Taro", 35.00,
                "Ideal for school and art projects\n" +
                "Grammage: 80 gsm\n" +
                "Color: Taro\n" +
                "Packaging Size: 3 sheets per roll",
            R.drawable.cartolina_taro),
        ProductData(44, "Joy Paper Clips", 35.00,
                "A desk accessory must-have to keep your documents securely in place.\n" +
                "Attr: Vinyl-coated\n" +
                "Size: 50 mm\n" +
                "Color: Assorted colors\n" +
                "Packaging Size: 100 pcs per box",
            R.drawable.clip_joy_100),
        ProductData(45, "Joy Clipboard A4", 60.00,
                "Handy for holding files and documents in place while on the go\n" +
                "Attr: Wood\n" +
                "Size: A4/ 9 x 12.5 inches\n" +
                "Color: Brown",
            R.drawable.clipboard_joy_a4),
        ProductData(46, "Maped Compass", 155.00,
                "Maped designed the Stop System to enable simple and effective use of the compass. 1 - Lower the lever 2 - Adjust the spacing of the arms 3 - Close the lever to lock in the arms 4 - Draw a perfect circle. Easy locking in of the arms guarantees you perfect drawing.\n" +
                "\n" +
                " \n" +
                "\n" +
                "With Patented Stop System concept: locking in the arms\n" +
                "Protected point for safety\n" +
                "Color: Black\n" +
                "Packaging Size: 1 pc",
            R.drawable.compass_maped),
        ProductData(47, "Seno Correction Tape", 26.00,
                "Strong coverage\n" +
                "Non-toxic and environment-friendly\n" +
                "Model: PS-09R\n" +
                "Tape Width: 5mm\n" +
                "Tape Length: 8 meters",
            R.drawable.correction_tape),
        ProductData(48, "Crayola Crayons 8", 40.00,
                "Preferred by teachers, Crayola Crayons are perfect for coloring and creativity in school or at home.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Attr: Classic, 8 Colors\n" +
                "Durable and Double-Wrapped\n" +
                "Safe and Non-Toxic\n" +
                "Packaging Size: 8 crayons per box",
            R.drawable.crayons_crayola_8),
        ProductData(49, "Crayola Crayons 16", 85.00,
                "Preferred by teachers, Crayola Crayons are perfect for coloring and creativity in school or at home.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Attr: Classic, 16 Colors\n" +
                "Durable and Double-Wrapped\n" +
                "Safe and Non-Toxic\n" +
                "Packaging Size: 16 crayons per box",
            R.drawable.crayons_crayola_16),
        ProductData(50, "Crayola Crayons 24", 120.00,
                "Preferred by teachers, Crayola Crayons are perfect for coloring and creativity in school or at home.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Attr: Classic, 24 Colors\n" +
                "Durable and Double-Wrapped\n" +
                "Safe and Non-Toxic\n" +
                "Packaging Size: 24 crayons per box",
            R.drawable.crayons_crayola_24),
        ProductData(51, "Crayola Crayons 48", 180.00, "Preferred by teachers, Crayola Crayons are perfect for coloring and creativity in school or at home.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Attr: Classic, 48 Colors\n" +
                "Durable and Double-Wrapped\n" +
                "Safe and Non-Toxic\n" +
                "Packaging Size: 48 crayons per box",
            R.drawable.crayons_crayola_48),
        ProductData(52, "Dorco Cutter", 185.00,
                "Superior cutting performance by DORCO 's high-technique heat treatment and 3-steps of grinding process\n" +
                "Screw-Lock System to hold the blade securely\n" +
                "Heavy-Duty\n" +
                "User-friendly design\n" +
                "Blade Size: 18mm \n" +
                "Model: L601\n" +
                "Color: Assorted Colors",
            R.drawable.cutter_dorco_18),
        ProductData(53, "Acura Cutting Mat A3", 420.00,
                "Durable cutting mat ideal for your home and office your cutting works, as well as protecting table top surfaces.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Color: Green\n" +
                "Size: A3",
            R.drawable.cuttingmat_green_a3),
        ProductData(54, "Acura Cutting Mat A4", 210.00,
                "Durable cutting mat ideal for your home and office your cutting works, as well as protecting table top surfaces.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Color: Green\n" +
                "Size: A4", R.drawable.cuttingmat_green_a4),
        ProductData(55, "Maped Technic Duo Eraser", 32.00,
                "Dual-Use Eraser: White side: pencil and graphite lead; Blue side: ink\n" +
                "PVC-free\n" +
                "Size: 18 x 12 x 39 mm\n" +
                "Color: Blue/White\n" +
                "Packaging Size: 2 pcs per blister pack",
            R.drawable.eraser_maped),
        ProductData(56, "MONGOL Eraser White", 34.00,
                "Attr: SZ-20\n" +
                "Premium Exam-Standard eraser\n" +
                "Smudge-free\n" +
                "Dust-free\n" +
                "Size: Large\n" +
                "Color: White",
            R.drawable.eraser_mongol),
        ProductData(57, "Joy Fastener 50s", 50.00,
                "A must-have for office and school filing needs.\n" +
                "Attr: Plastic\n" +
                "Size: 7cm \n" +
                "Color: Assorted\n" +
                "Packaging Size: 50 pcs per box",
            R.drawable.fastener_joy_50s),
        ProductData(58, "HBW Highlighter Blue", 20.00,
                "HBW Highlighter Marker\n" +
                "Model: 2091\n" +
                "In brilliant and neon translucent colors\n" +
                "Fade-resistant\n" +
                "Tip Style: Chisel\n" +
                "Ink Color: Blue\n" +
                "Packaging Size: 1 pc.",
            R.drawable.highlighter_blue),
        ProductData(59, "HBW Highlighter Green", 20.00,
                "HBW Highlighter Marker\n" +
                "Model: 2091\n" +
                "In brilliant and neon translucent colors\n" +
                "Fade-resistant\n" +
                "Tip Style: Chisel\n" +
                "Ink Color: Green\n" +
                "Packaging Size: 1 pc.",
            R.drawable.highlighter_green),
        ProductData(60, "HBW Highlighter Orange", 20.00,
                "HBW Highlighter Marker\n" +
                "Model: 2091\n" +
                "In brilliant and neon translucent colors\n" +
                "Fade-resistant\n" +
                "Tip Style: Chisel\n" +
                "Ink Color: Orange\n" +
                "Packaging Size: 1 pc.",
            R.drawable.highlighter_orange),
        ProductData(61, "HBW Highlighter Pink", 20.00,
                "HBW Highlighter Marker\n" +
                "Model: 2091\n" +
                "In brilliant and neon translucent colors\n" +
                "Fade-resistant\n" +
                "Tip Style: Chisel\n" +
                "Ink Color: Pink\n" +
                "Packaging Size: 1 pc.",
            R.drawable.highlighter_pink),
        ProductData(62, "HBW Highlighter Yellow", 20.00,
                "HBW Highlighter Marker\n" +
                "Model: 2091\n" +
                "In brilliant and neon translucent colors\n" +
                "Fade-resistant\n" +
                "Tip Style: Chisel\n" +
                "Ink Color: Yellow\n" +
                "Packaging Size: 1 pc.",
            R.drawable.highlighter_yellow),
        ProductData(63, "Logitech M170 Wireless Mouse Black", 650.00,
                "Strong, consistent wireless connection from distances up to 10-meters (33-feet) away\n" +
                "12-month battery life\n" +
                "with Plug-and-Play connection\n" +
                "Designed for ultimate comfort and mobility\n" +
                "With an ambidextrous design that easily fits within your laptop bag, so you can get to work anywhere.\n" +
                "Easy navigation thanks to a controlled line-by-line scrolling and optical tracking.\n" +
                "Buttons: 3 buttons + 1 wheel\n" +
                "Line-by-line scrolling with scroll wheel\n" +
                "2.4Ghz wireless mouse with Nano receiver\n" +
                "Model: M171\n" +
                "Color: Black",
            R.drawable.mouse_black),
        ProductData(64, "Logitech M170 Wireless Mouse Grey", 650.00,
                "Strong, consistent wireless connection from distances up to 10-meters (33-feet) away\n" +
                "12-month battery life\n" +
                "with Plug-and-Play connection\n" +
                "Designed for ultimate comfort and mobility\n" +
                "With an ambidextrous design that easily fits within your laptop bag, so you can get to work anywhere.\n" +
                "Easy navigation thanks to a controlled line-by-line scrolling and optical tracking.\n" +
                "Buttons: 3 buttons + 1 wheel\n" +
                "Line-by-line scrolling with scroll wheel\n" +
                "2.4Ghz wireless mouse with Nano receiver\n" +
                "Model: M171\n" +
                "Color: Grey",
            R.drawable.mouse_grey),
        ProductData(65, "Fellowes Mousepad Black", 300.00,
                "Protect your desktop and enhance mousing performance with an optical and laser mouse friendly mousepad\u200B.\n" +
                "\n" +
                "With built-in antibacterial Microban® protection that fights the growth of harmful bacteria for the lifetime of the product\u200B\n" +
                "Rubber base keeps mousepad firmly in place all day whilst protects desktop from scratches\n" +
                "Color: Black",
            R.drawable.mouse_pad_black),
        ProductData(66, "Fellowes Mousepad Grey", 300.00,
                "Protect your desktop and enhance mousing performance with an optical and laser mouse friendly mousepad\u200B.\n" +
                "\n" +
                "With built-in antibacterial Microban® protection that fights the growth of harmful bacteria for the lifetime of the product\u200B\n" +
                "Rubber base keeps mousepad firmly in place all day whilst protects desktop from scratches\n" +
                "Color: Grey",
            R.drawable.mouse_pad_grey),
        ProductData(67, "Corona Notebook Medium", 80.00,
                "A school and office supply staple for taking those important notes.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Size: 152 x 216 mm\n" +
                "Color: Blue\n" +
                "Attr: Spiral\n" +
                "Packaging Size: 100 Leaves",
            R.drawable.notebook_corona_152x216),
        ProductData(68, "Corona Notebook Large", 120.00,
                "A school and office supply staple for taking those important notes.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Size: 178 x 254 mm\n" +
                "Color: Blue\n" +
                "Attr: Spiral\n" +
                "Packaging Size: 100 Leaves",
            R.drawable.notebook_corona_178x254),
        ProductData(69, "Construction Paper 20s", 30.00,
                "Versatile paper for your arts and crafts project at home and in school\n" +
                "Size: 9 x 12 inches\n" +
                "Color: Assorted colors\n" +
                "Packaging Size: 20 sheets per pack",
            R.drawable.paper_construction_20),
        ProductData(70, "Corona Graphing Paper 20s", 42.00,
                "A school essential for plotting graphs and other data\n" +
                "Size: Letter / 216 x 280 mm\n" +
                "Packaging Size: 20 sheets per pack",
            R.drawable.paper_graphing),
        ProductData(71, "Corona Index Paper 3x5", 30.00,
                "Office and school supply staple for cataloguing notes and other details\n" +
                "Attr: Index Card Plain\n" +
                "Size: 3 x 5 inches\n" +
                "Color: White\n" +
                "Packaging Size: 50 pcs per pack",
            R.drawable.paper_index_3x5),
        ProductData(72, "Corona Index Paper 4x6", 40.00,
                "Office and school supply staple for cataloguing notes and other details\n" +
                "Attr: Index Card Plain\n" +
                "Size: 4 x 6 inches\n" +
                "Color: White\n" +
                "Packaging Size: 50 pcs per pack",
            R.drawable.paper_index_4x6),
        ProductData(73, "Corona Index Paper 5x8", 50.00,
                "Office and school supply staple for cataloguing notes and other details\n" +
                "Attr: Index Card Plain\n" +
                "Size: 5 x 8 inches\n" +
                "Color: White\n" +
                "Packaging Size: 50 pcs per pack",
            R.drawable.paper_index_5x8),
        ProductData(74, "Veco Manila Paper", 15.00,
                "Ideal for your art and DIY projects\n" +
                "Size: 36 x 48 inches\n" +
                "Color: Yellow\n" +
                "Packaging Size: 2 pcs per pack",
            R.drawable.paper_manila_36x48),
        ProductData(75, "3M Page Markers", 270.00,
                "Ideal for conveniently marking important documents at work\n" +
                "Size: 0.5 x 1.75 inches\n" +
                "Color: 5 Colors\n" +
                "Packaging Size: 500 markers per pack",
            R.drawable.paper_pagemarker),
        ProductData(76, "Faber-Castell Colored Pencil 12s", 170.00,
                "Hexagonal-shaped colour pencils\n" +
                "In brilliant and vivid colours\n" +
                "Highest break-resistance due to secural bonding process (SV)\n" +
                "Wood from certified sustainable forestry\n" +
                "Attr: Long; #115852\n" +
                "Packaging Size: 12 colour pencils per wallet",
            R.drawable.pencil_fabercastle_12),
        ProductData(77, "Joy Pencil Sharpener 2 Holes", 7.00,
                "Pocket sharpener handy for school or work\n" +
                "Attr: 2 Holes\n" +
                "Color: Assorted Colors\n" +
                "Packaging Size: 1 pc",
            R.drawable.pencil_sharpener_1),
        ProductData(78, "Joy Pencil Sharpener 2 Holes w/Chassis", 15.00,
                "Pocket sharpener handy for school or work\n" +
                "Attr: 2 Holes\n" +
                "Model No.: OS-28H0\n" +
                "Color: Assorted Colors\n" +
                "Packaging Size: 1 pc",
            R.drawable.pencil_sharpener_2),
        ProductData(79, "Joy Pencil Sharpener 2 Holes w/Chassis 2", 18.00,
                "Pocket sharpener handy for school or work\n" +
                "Comes with an eraser\n" +
                "Attr: 2 Holes\n" +
                "Model No.: OS-28H1\n" +
                "Color: Assorted Colors\n" +
                "Packaging Size: 1 pc",
            R.drawable.pencil_sharpener_3),
        ProductData(80, "Axis Envelope", 99.00,
                "Versatile and handy envelope ideal for easy storage.\n" +
                "\n" +
                "Size: 11 x 8.5 inches\n" +
                "With 2 zipped compartments\n" +
                "Color: Assorted colors",
            R.drawable.pencilcase_axis_envelope),
        ProductData(81, "Axis Envelope 2", 110.00,
                "Versatile and handy envelope ideal for easy storage.\n" +
                "\n" +
                "Size: 11 x 8.5 inches\n" +
                "Color: Assorted Colors",
            R.drawable.pencilcase_axis_envelope2),
        ProductData(82, "UK Office Puncher", 190.00,
                "Heavy-Duty Puncher \n" +
                "Attr: 2-Hole\n" +
                "Size: 7 cm\n" +
                "Color: Assorted Colors",
            R.drawable.puncher_7m),
        ProductData(83, "Rubberband Brown 350gms", 200.00,
            "Band Type: Flat\n" +
                "Size: 350 grams\n" +
                "Color: Brown",
            R.drawable.rubberband_brown),
        ProductData(84, "Joy Metal Ruler 12", 60.00,
                "Handy basic measuring tool for school and work projects.\n" +
                "\n" +
                "Durable and sturdy ideally used in workshops\n" +
                "Material: Stainless, Metal\n" +
                "Color: Silver\n" +
                "Size: 12 inches",
            R.drawable.ruler_joy_12),
        ProductData(85, "Joy Metal Ruler 18", 100.00,
                "Handy basic measuring tool for school and work projects.\n" +
                " \n" +
                "\n" +
                "Durable and sturdy ideally used in workshops\n" +
                "Material: Metal\n" +
                "Color: Gray\n" +
                "Size: 18 inches",
            R.drawable.ruler_joy_18),
        ProductData(86, "Joy Plastic Ruler 12", 45.00,
                "Handy basic measuring tool for school and work projects.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Flexible and transparent for convenience\n" +
                "Material: Plastic\n" +
                "Color: Clear\n" +
                "Size: 12 inches",
            R.drawable.ruler_joy_plastic_12),
        ProductData(87, "Joy Protractor Ruler", 20.00,
                "Basic Math tool for measuring angles.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Material: Plastic/Acrylic\n" +
                "Color: Clear\n" +
                "Size: 12 cm",
            R.drawable.ruler_joy_protractor_11),
        ProductData(88, "Scotch Scissors 3m", 90.00,
                "Kiddie scissors with soft touch handles ideal for kids 4 years old and above.\n" +
                "\n" +
                "Blades with blunt tip designed for safety\n" +
                "Soft touch handles for easy and comfortable grip\n" +
                "Size: 5 inches\n" +
                "Color: Assorted",
            R.drawable.scissors_3m),
        ProductData(89, "Maped Scissors 7m", 150.00,
                "Advanced Eco-Friendly Scissors\n" +
                "Stainless steel blades and rivet\n" +
                "Comfort and accuracy for every type of grip or hand size\n" +
                "Ergonomic 3D handles made of 60% recycled plastic\n" +
                "Scissor Size: 7 inches\n" +
                "Color: Black",
            R.drawable.scissors_7m),
        ProductData(90, "Eagle Stapler Medium", 105.00,
            "Soft grip handle\n" +
                "Intergrated refill box stores spare staples\n" +
                "Rotatable anvil for stapling & pinning\n" +
                "Non skid bottom pad\n" +
                "Staple Size: #35\n" +
                "Stapling Margin: 48mm\n" +
                "Stapling Capacity: 20 sheets\n" +
                "Color: Assorted colors\n" +
                "Packaging Size: 1 pc.",
            R.drawable.staple_eagle_m),
        ProductData(91, "Eagle Stapler Small", 35.00,
                "Mini-size plastic stapler with soft grip design\n" +
                "With staple remover at the back\n" +
                "Reload indicator\n" +
                "Type: Mini stapler\n" +
                "Material: Plastic\n" +
                "Staple Size: 26/6\n" +
                "Stapling Margin: 19mm\n" +
                "Stapling Capacity: 15 Sheets",
            R.drawable.staple_eagle_s),
        ProductData(92, "Eagle Stapler Remover", 30.00,
                "Classic plastic staple remover\n" +
                "Handy grip surface\n" +
                "Metal jaws and coated finish\n" +
                "Removes all standard size staples\n" +
                "Grip lock switch for easy storage\n" +
                "Model: R5026B\n" +
                "Color: Assorted Colors",
            R.drawable.staple_remover),
        ProductData(93, "Brite Staple Wire 6", 55.00,
                "For use on T-30 Gun Tacker\n" +
                "Heavy-duty\n" +
                "Ideal for chipboard and softwood\n" +
                "Size: 6mm (1/4\")\n" +
                "Packaging Size: 2,000 pcs per box",
            R.drawable.staple_wire_6),
        ProductData(94, "Brite Staple Wire 12", 55.00,
                "For use on T-50 Gun Tacker\n" +
                "Heavy-duty\n" +
                "Ideal for chipboard and softwood\n" +
                "Size: 12mm (1/2\")\n" +
                "Packaging Size: 1,000 pcs per box",
            R.drawable.staple_wire_12),
        ProductData(95, "Sandisk USB 16gb", 300.00,
                "With its stylish, compact design and generous capacity, the Cruzer Blade USB Flash Drive makes it easy to back up, transfer, and share your files. This USB drive lets you carry your photos, movies, music, and personal data wherever you go.\n" +
                " \n" +
                "\n" +
                "With compact design for maximum portability\n" +
                "High-Capacity Drive accommodates your favorite media files\n" +
                "With simple drag-and-drop file backup feature\n" +
                "Model: Cruzer Blade\n" +
                "Interface: 2.0\n" +
                "Capacity: 16GB",
            R.drawable.usb_16),
        ProductData(96, "Sandisk USB 32gb", 450.00,
                "With its stylish, compact design and generous capacity, the Cruzer Blade USB Flash Drive makes it easy to back up, transfer, and share your files. This USB drive lets you carry your photos, movies, music, and personal data wherever you go.\n" +
                " \n" +
                "\n" +
                "With compact design for maximum portability\n" +
                "High-Capacity Drive accommodates your favorite media files\n" +
                "With simple drag-and-drop file backup feature\n" +
                "Model: Cruzer Blade\n" +
                "Interface: 2.0\n" +
                "Capacity: 32GB",
            R.drawable.usb_32),
        ProductData(97, "Sandisk USB 64gb", 650.00,
                "With its stylish, compact design and generous capacity, the Cruzer Blade USB Flash Drive makes it easy to back up, transfer, and share your files. This USB drive lets you carry your photos, movies, music, and personal data wherever you go.\n" +
                " \n" +
                "\n" +
                "With compact design for maximum portability\n" +
                "High-Capacity Drive accommodates your favorite media files\n" +
                "With simple drag-and-drop file backup feature\n" +
                "Model: Cruzer Blade\n" +
                "Interface: 2.0\n" +
                "Capacity: 64GB",
            R.drawable.usb_64),
        ProductData(98, "Whiteboard 12x8", 180.00,
                "A presentation staple ideal for office and school use.\n" +
                "Attr: Whiteboard with Aluminum Frame\n" +
                "Size: 12 x 8 inches\n" +
                "Color: White\n" +
                "Packaging Size: 1 pc.",
            R.drawable.whiteboard_12x8),
        ProductData(99, "Whiteboard 12x10", 250.00,
                "A presentation staple ideal for office and school use.\n" +
                "Attr: Whiteboard with Aluminum Frame\n" +
                "Size: 12 x 10 inches\n" +
                "Color: White\n" +
                "Packaging Size: 1 pc.",
            R.drawable.whiteboard_12x10),
        ProductData(100, "Whiteboard 12x12", 260.00,
                "A presentation staple ideal for office and school use.\n" +
                "Attr: Whiteboard with Aluminum Frame\n" +
                "Size: 12 x 12 inches\n" +
                "Color: White\n" +
                "Packaging Size: 1 pc.",
            R.drawable.whiteboard_12x12),
        ProductData(101, "Whiteboard 18x12", 350.00,
                "A presentation staple ideal for office and school use.\n" +
                "Attr: Whiteboard with Aluminum Frame\n" +
                "Size: 18 x 12 inches\n" +
                "Color: White\n" +
                "Packaging Size: 1 pc.",
            R.drawable.whiteboard_18x12),
    )
}*/