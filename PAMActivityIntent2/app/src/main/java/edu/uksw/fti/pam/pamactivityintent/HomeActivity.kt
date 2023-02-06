package edu.uksw.fti.pam.pamactivityintent


import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.uksw.fti.pam.pamactivityintent.ui.theme.PAMActivityIntentTheme

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PAMActivityIntentTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val username = getIntent().getStringExtra("username")?:""

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        HomeScaffold()
                    }
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScaffold(){
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val coroutineScope = rememberCoroutineScope()
    val mCheckedState = remember{ mutableStateOf(false)}
    val selectedIndex = remember{ mutableStateOf(0) }


    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = {
                    Image(
                        painter = painterResource(id = R.drawable.im_logo_1),
                        contentDescription = null,
                        modifier = Modifier
                            .requiredHeight(36.dp)
                            .padding(end = 1.dp)
                    )
                    Text(text = "MangaDex")
                },
                actions = {
                    IconButton(onClick = { /* doSomething() */ }) {
                        Icon(Icons.Filled.Search, contentDescription = "Localized description")
                    }
                    Switch(checked = mCheckedState.value, onCheckedChange = {mCheckedState.value = it})


                },

                backgroundColor = Color(0xFFF0F1F2),
                elevation = 10.dp
            )
        },
        bottomBar = {
            BottomAppBar(
                backgroundColor = Color(0xFFF0F1F2),
            ){
                BottomNavigationItem(icon = {
                    Icon(imageVector = Icons.Default.Home,"")
                },
                    selected = (selectedIndex.value == 0),
                    onClick = {
                        selectedIndex.value = 0
                    })

                BottomNavigationItem(icon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_bookmark2),
                        contentDescription = null,
                        modifier = Modifier.size(25.dp)
                    )
                },
                    selected = (selectedIndex.value == 1),
                    onClick = {
                        selectedIndex.value = 1
                    })

                BottomNavigationItem(icon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_book_open2),
                        contentDescription = null,
                        modifier = Modifier.size(25.dp)
                    )
                },
                    selected = (selectedIndex.value == 2),
                    onClick = {
                        selectedIndex.value = 2
                    })
                BottomNavigationItem(icon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_users),
                        contentDescription = null,
                        modifier = Modifier.size(22.dp)
                    )
                },
                    selected = (selectedIndex.value == 3),
                    onClick = {
                        selectedIndex.value = 3
                    })
                BottomNavigationItem(icon = {
                    Icon(imageVector = Icons.Default.Person,"")
                },
                    selected = (selectedIndex.value == 4),
                    onClick = {
                        selectedIndex.value = 4
                    })
            }

        },
        content = {
            Body()
        }
    )
}

@Composable
fun Body(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
            .padding(top = 10.dp)
            .verticalScroll(rememberScrollState())
    ) {
        /*Text(text = "Body Content", color = Color(0xFF0F9D58))*/

        Column (
            modifier = Modifier
                /*.fillMaxSize()*/
        ){
            Text(
                text = "Popular New Titles",
                fontFamily = FontFamily.Monospace,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold
                )
            Card(
                modifier = Modifier
                    .padding(top = 5.dp),
                elevation = 4.dp,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.im_back_kota),
                    contentDescription = null,
                )
                Column(
                    modifier = Modifier
                        .padding(10.dp),
                    horizontalAlignment = Alignment.Start


                ) {
                    Text(
                        text = "No.09",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold
                        )

                    Row(

                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.im_pop_title2),
                            contentDescription = null,
                            modifier = Modifier
                                .requiredHeight(150.dp)
                                /*.requiredWidth(100.dp)*/,
                            alignment = Alignment.TopStart
                        )
                        Column (
                            modifier = Modifier
                                .requiredWidth(240.dp)
                                .padding(start = 10.dp),
                        ) {
                            Text(
                                text = "Amarimono Isekaijin no Jiyuu Seikatsu: Yuusha ja Nai node...  ",
                                fontWeight = FontWeight.SemiBold
                            )
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                Card (
                                    backgroundColor = Color(0xffF0F1F2)
                                        ) {
                                    Text(
                                        text = "ACTION",
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.padding(1.dp)
                                        )
                                }
                                Card (
                                    backgroundColor = Color(0xffF0F1F2)
                                        ){
                                    Text(
                                        text = "ADNVETURE",
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.padding(1.dp)
                                    )
                                }
                                Card (
                                    backgroundColor = Color(0xffF0F1F2)
                                        ){
                                    Text(
                                        text = "FANTASY",
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.padding(1.dp)
                                    )
                                }
                                Card (
                                    backgroundColor = Color(0xffF0F1F2)
                                        ){
                                    Text(
                                        text = "ISEKAI",
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.padding(1.dp)
                                    )
                                }
                            }
                            Text(
                                text = "Shinichi Sagara, a black corporate warrior. After overcoming a nightmare of consecutive workdays, he finally got on a bus to return home, but... ",
                                fontSize = 10.sp)
                            Text(
                                text = "Fujimori Fukuro, Muramatsu Mayu",
                                fontSize = 13.sp,
                                fontStyle = FontStyle.Italic,
                                modifier = Modifier.padding(top = 25.dp)
                            )


                        }

                    }
                    
                }

            }

        }

        Column(
            modifier = Modifier.padding(top = 20.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement  =  Arrangement.SpaceBetween
            )
            {
                Text(
                    text = "Latest Updates",
                    fontFamily = FontFamily.Monospace,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_round_arrow_forward_24),
                    contentDescription = null,
                )

            }

            Row(
                horizontalArrangement = Arrangement.spacedBy(5.dp)

            ) {
                Card(
                    backgroundColor = Color(0xffF0F1F2),
                    modifier = Modifier.requiredWidth(180.dp)

                ) {
                    Row(
                        modifier = Modifier.padding(5.dp),
                        horizontalArrangement = Arrangement.spacedBy(5.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.im_late_1),
                            contentDescription = null,
                            modifier = Modifier.requiredHeight(100.dp)

                        )
                        Column(
                            verticalArrangement = Arrangement.spacedBy(2.dp)
                        ) {
                            Text(
                                text = "Kimi no Iru Machi",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .requiredHeight(25.dp)


                            )
                            Row(
                                modifier = Modifier.padding(top = 5.dp),
                                horizontalArrangement = Arrangement.spacedBy(1.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.im_flag_1),
                                    contentDescription = null,
                                    )
                                Text(
                                    text = "Vol. 7 Ch.61",
                                    fontSize = 9.sp,

                                )
                            }
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(1.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.ic_users_1),
                                    contentDescription = null,
                                )
                                Text(
                                    text = "Hayate",
                                    fontSize = 9.sp,

                                    )
                            }
                            Text(
                                text = "18 secs",
                                fontSize = 9.sp,

                                )
                            Icon(
                                painter = painterResource(id = R.drawable.ic_chat_1),
                                contentDescription = null
                            )

                        }

                    }
                    
                    
                }
                Card(
                    backgroundColor = Color(0xffF0F1F2),
                    modifier = Modifier.requiredWidth(180.dp)

                ) {
                    Row(
                        modifier = Modifier.padding(5.dp),
                        horizontalArrangement = Arrangement.spacedBy(5.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.im_late_2),
                            contentDescription = null,
                            modifier = Modifier.requiredHeight(100.dp)
                            )
                        Column(
                            verticalArrangement = Arrangement.spacedBy(2.dp)
                        ) {
                            Text(
                                text = "Sword Art Online: Progressive - Ku...",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .requiredHeight(25.dp)

                            )
                            Row(
                                modifier = Modifier.padding(top = 5.dp) ,
                                horizontalArrangement = Arrangement.spacedBy(1.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.im_flag_2),
                                    contentDescription = null,
                                )
                                Text(
                                    text = "Vol. 3 Ch.16 - 016",
                                    fontSize = 9.sp,

                                    )
                            }
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(1.dp)) {

                                Image(
                                    painter = painterResource(id = R.drawable.ic_users_1),
                                    contentDescription = null,
                                )
                                Text(
                                    text = "Dreadful Decoding",
                                    fontSize = 9.sp,

                                    )
                            }
                            Text(
                                text = "2 mins",
                                fontSize = 9.sp,

                                )
                            Icon(
                                painter = painterResource(id = R.drawable.ic_chat_1),
                                contentDescription = null
                            )

                        }

                    }


                }



            }
        }
        Column(
            modifier = Modifier.padding(top = 20.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement  =  Arrangement.SpaceBetween
            ){
                Text(
                    text = "Seasonal",
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = FontFamily.Monospace,
                    fontSize = 20.sp,

                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_round_arrow_forward_24),
                    contentDescription = null,
                )

            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ){
                Card(
                    backgroundColor = Color(0xffF0F1F2),
                    modifier = Modifier
                        .requiredWidth(180.dp)
                        .requiredHeight(120.dp)

                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(5.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.im_se_1),
                            contentDescription = null,
                            modifier = Modifier.requiredHeight(120.dp)

                        )
                        Column(
                            modifier = Modifier
                                .padding(top = 8.dp)
                                .padding(start = 5.dp)
                                .requiredWidth(120.dp),
                            verticalArrangement = Arrangement.spacedBy(2.dp)
                        ) {
                            Text(
                                text = "Uzaki-chan Wants to Hang Out!",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .requiredHeight(25.dp)

                            )
                            Text(
                                text = "Annoying! Cute! But Annoying! Shinichi Sakurai is a grumpy-faced, athletic and quiet college student who just wants to be left alone,  ",
                                fontSize = 9.sp,

                                )

                        }

                    }


                }
                Card(
                    backgroundColor = Color(0xffF0F1F2),
                    modifier = Modifier
                        .requiredWidth(180.dp)
                        .requiredHeight(120.dp)

                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(5.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.im_se_2),
                            contentDescription = null,
                            modifier = Modifier.requiredHeight(120.dp)

                        )
                        Column(
                            modifier = Modifier
                                .padding(top = 8.dp)
                                .padding(start = 5.dp)
                                .requiredWidth(120.dp),
                            verticalArrangement = Arrangement.spacedBy(2.dp)
                        ) {
                            Text(
                                text = "Blue Lock",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .requiredHeight(25.dp)

                            )
                            Text(
                                text = "oichi Isagi lost the opportunity to go to the national high school championships because he passed to his teammate... ",
                                fontSize = 9.sp,

                                )

                        }

                    }


                }
            }


        }
        Column(
            modifier = Modifier.padding(top = 20.dp)
        ){
            Text(
                text = "Recently Added",
                fontFamily = FontFamily.Monospace,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold

                )
            Row(
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Column() {
                    Image(
                        painter = painterResource(id = R.drawable.im_ra_1),
                        contentDescription = null,
                        modifier = Modifier.requiredHeight(120.dp)

                    )

                }
                Column() {
                    Image(
                        painter = painterResource(id = R.drawable.im_ra_2),
                        contentDescription = null,
                        modifier = Modifier.requiredHeight(120.dp)

                    )

                }
                Column() {
                    Image(
                        painter = painterResource(id = R.drawable.im_ra_3),
                        contentDescription = null,
                        modifier = Modifier.requiredHeight(120.dp)

                    )

                }
                Column() {
                    Image(
                        painter = painterResource(id = R.drawable.im_ra_4),
                        contentDescription = null,
                        modifier = Modifier.requiredHeight(120.dp)

                    )

                }

                
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PAMActivityIntentTheme {
        HomeScaffold()
    }
}