package edu.uksw.fti.pam.pamactivityintent


import edu.uksw.fti.pam.pamactivityintent.R
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.uksw.fti.pam.pamactivityintent.ui.theme.PAMActivityIntentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PAMActivityIntentTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LoginForm()
                }
            }
        }
    }
}

@Composable
fun LoginForm() {
    val lContext = LocalContext.current

    var usernameInput by remember { mutableStateOf("") }
    var passwordInput by remember { mutableStateOf("") }

    val paddingModifier = Modifier.padding(10.dp)



    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally



    ) {
        Row(
            modifier = Modifier
                .padding(top = 30.dp)
                .padding(bottom = 30.dp),

            ) {
            Image(
                painter = painterResource(id = R.drawable.im_logo_black),
                contentDescription = null,
                modifier = Modifier
                    .requiredHeight(40.dp)
            )

            Text(text = "MangaDex", Modifier.padding(8.dp),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,)
            }
            

        Card(
            elevation = 10.dp
        ) {
            Column(
                modifier = paddingModifier,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(text = "Sign in to your account",
                    Modifier.padding(8.dp),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                )

                Column() {
                    Text(text = "Username or email",
                        Modifier
                            .padding(top = 8.dp)
                            .padding(start = 5.dp),
                        fontSize = 14.sp,
                    )
                    
                    OutlinedTextField(
                        value = usernameInput.toString(),
                        onValueChange = {usernameInput = it},

                        modifier = Modifier.fillMaxWidth(),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            cursorColor = Color(0xffFF6740),
                            focusedBorderColor = Color(0xffFF6740),
                            unfocusedBorderColor = Color(0xffE6E6E6),
                            backgroundColor = Color(0xffE6E6E6),
                        )
                    )

                }

                Column() {
                    Text(text = "Password",
                        Modifier
                            .padding(top = 8.dp)
                            .padding(start = 5.dp),
                        fontSize = 14.sp,

                    )

                    OutlinedTextField(
                        value = passwordInput.toString(),
                        onValueChange = {passwordInput = it},

                        visualTransformation = PasswordVisualTransformation(),
                        modifier = Modifier.fillMaxWidth(),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            cursorColor = Color(0xffFF6740),
                            focusedBorderColor = Color(0xffFF6740),
                            unfocusedBorderColor = Color(0xffE6E6E6),
                            backgroundColor = Color(0xffE6E6E6)
                        )
                    )
                    Text(text = "Forgot Password?",
                        Modifier.padding(bottom = 8.dp),
                        fontSize = 12.sp,
                    )


                }



                    Row() {
                        Button(
                            onClick = { /*TODO*/
                                val isAuthenticated = doAuth(usernameInput,passwordInput)
                                if(isAuthenticated)
                                    lContext.startActivity(
                                        Intent(lContext,HomeActivity::class.java)
                                            .apply {
                                                putExtra("username",usernameInput)
                                            }
                                    )


                            },
                            modifier = paddingModifier,
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xffFF6740))


                        )
                        {
                            Text(text = "Sign in",
                                color = Color.White)
                        }
                        Button(onClick = { /*TODO*/ }, modifier = paddingModifier,
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xffFF6740))
                        ) {
                            Text(text = "Register",
                                color = Color.White)
                            
                        }
                    }
                    


            }

        }


    }
}

internal fun doAuth(username: String,password:String): Boolean {
    return (username.equals("admin") && password.equals("admin"))
}


@Preview(showBackground = true)
@Composable
fun LoginFormPreview(){
    PAMActivityIntentTheme {
        LoginForm()
    }
}

