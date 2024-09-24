package com.example.artspace

import android.content.res.Configuration
import android.os.Bundle
import androidx.annotation.DrawableRes
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.artspace.ui.theme.ArtspaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val configuration = resources.configuration
        val orientation = configuration.orientation

        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.portrait)
        } else {
            setContentView(R.layout.landscape)
        }
        setContent {
            ArtspaceTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
                    ArtSpaceScreen()
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtspaceTheme {
        ArtSpaceScreen()
    }
}

@Composable
fun ArtSpaceScreen(modifier: Modifier = Modifier) {
    val firstArtwork = R.drawable.albedo_art
    val secondArtwork = R.drawable.erza_art
    val thirdArtwork = R.drawable.jellal_art
    val fourthArtwork = R.drawable.jujutsu
    val fifthArtwork = R.drawable.rimuru_art

    var title by remember {
        mutableIntStateOf(R.string.albedo_art)
    }
    var author by remember {
        mutableIntStateOf(R.string.albedo_auth)
    }

    var year by remember {
        mutableIntStateOf(R.string.albedo_art_yr)
    }

    var currentArtwork by remember {
        mutableIntStateOf(firstArtwork)
    }

        Column(
            modifier = modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            ArtworkDisplay(currentArtwork = currentArtwork)
            Spacer(modifier = modifier.size(16.dp))
            ArtworkTitle(title = title, year = year, author = author)
            Spacer(modifier = modifier.size(25.dp))
            Row(
                modifier = modifier.padding(horizontal = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally)
            ) {
                Button(
                    onClick = {
                        when (currentArtwork) {
                            firstArtwork -> {
                                currentArtwork = fifthArtwork
                                title = R.string.rimuru_art
                                author = R.string.rimuru_auth
                                year = R.string.rimuru_art_yr
                            }

                            secondArtwork -> {
                                currentArtwork = firstArtwork
                                title = R.string.albedo_art
                                author = R.string.albedo_auth
                                year = R.string.albedo_art_yr
                            }

                            thirdArtwork -> {
                                currentArtwork = secondArtwork
                                title = R.string.erza_art
                                author = R.string.erza_auth
                                year = R.string.erza_art_yr
                            }

                            fourthArtwork -> {
                                currentArtwork = thirdArtwork
                                title = R.string.jellal_art
                                author = R.string.jellal_auth
                                year = R.string.jellal_art_yr
                            }

                            else -> {
                                currentArtwork = fourthArtwork
                                title = R.string.jujutsu
                                author = R.string.jujutsu_auth
                                year = R.string.jujutsu_yr
                            }
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White
                    ),
                    elevation = ButtonDefaults.buttonElevation(
                        defaultElevation = 1.dp,
                        pressedElevation = 0.dp,
                        focusedElevation = 0.dp
                    )
                ) {
                    Text(
                        text = "Previous",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = colorResource(id = R.color.purple_200)
                    )
                }

                Button(
                    onClick = {
                        when (currentArtwork) {
                            firstArtwork -> {
                                currentArtwork = secondArtwork
                                title = R.string.erza_art
                                author = R.string.erza_auth
                                year = R.string.erza_art_yr
                            }

                            secondArtwork -> {
                                currentArtwork = thirdArtwork
                                title = R.string.jellal_art
                                author = R.string.jellal_auth
                                year = R.string.jellal_art_yr
                            }

                            thirdArtwork -> {
                                currentArtwork = fourthArtwork
                                title = R.string.jujutsu
                                author = R.string.jujutsu_auth
                                year = R.string.jujutsu_yr
                            }

                            fourthArtwork -> {
                                currentArtwork = fifthArtwork
                                title = R.string.rimuru_art
                                author = R.string.rimuru_auth
                                year = R.string.rimuru_art_yr
                            }

                            else -> {
                                currentArtwork = firstArtwork
                                title = R.string.albedo_art
                                author = R.string.albedo_auth
                                year = R.string.albedo_art_yr
                            }
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.purple_200)
                    ),
                    elevation = ButtonDefaults.buttonElevation(
                        defaultElevation = 1.dp,
                        pressedElevation = 0.dp,
                        focusedElevation = 0.dp
                    )
                ) {
                    Text(
                        text = "     Next    ",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = colorResource(
                            id = R.color.black
                        )

                    )
                }

            }
        }
    }


@Composable
fun ArtworkDisplay(
    modifier: Modifier = Modifier,
    @DrawableRes currentArtwork: Int
) {
    Image(
        painter = painterResource(currentArtwork),
        contentDescription = stringResource(id = R.string.albedo_art),
        modifier = modifier.fillMaxWidth()
            .height(550.dp)
    )

}

    @Composable
    fun ArtworkTitle(
        @StringRes title: Int,
        @StringRes author: Int,
        @StringRes year: Int
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = title),
                fontSize = 32.sp,
                fontWeight = FontWeight.ExtraLight,
                fontStyle = FontStyle.Italic,
                color = colorResource(id = R.color.black)
            )

            Text(
                text = stringResource(id = author),
                fontSize = 18.sp,
                fontWeight = FontWeight.Thin,
                color = colorResource(id = R.color.gray_300)
            )

            Text(
                text = "— ${stringResource(id = year)} —",
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium,
                color = colorResource(id = R.color.black)
            )

        }
    }


