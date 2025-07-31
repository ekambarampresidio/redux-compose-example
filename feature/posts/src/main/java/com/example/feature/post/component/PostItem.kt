package com.example.feature.post.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import com.example.core.designsystem.resource.font_12
import com.example.core.designsystem.resource.font_15
import com.example.core.designsystem.resource.font_16
import com.example.core.designsystem.resource.size_10
import com.example.core.designsystem.resource.size_15
import com.example.core.designsystem.resource.size_48
import com.example.core.designsystem.resource.size_5
import com.example.core.model.Posts
import com.example.feature.post.R

@Composable
fun PostItem(
    modifier: Modifier = Modifier,
    posts: Posts
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.padding(horizontal = size_15, vertical = size_10)
    ) {
        Image(
            modifier = modifier
                .size(size = size_48)
                .clip(CircleShape)
                .align(Alignment.Top),
            contentScale = ContentScale.Crop,
            painter = painterResource(R.drawable.avatar),
            contentDescription = stringResource(R.string.image_profile)
        )
        Spacer(
            modifier = modifier.width(size_10)
        )
        Column {
            Text(
                text = posts.title,
                style = TextStyle(
                    fontSize = font_16,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(
                modifier = modifier.height(size_5)
            )
            Text(
                text = posts.content,
                style = TextStyle(
                    fontSize = font_15,
                    fontWeight = FontWeight.Normal,
                    color = Color.DarkGray
                ),
                overflow = TextOverflow.Ellipsis
            )
            Spacer(
                modifier = modifier.height(size_5)
            )
            Text(
                text = posts.date,
                style = TextStyle(
                    fontSize = font_12,
                    fontWeight = FontWeight.Normal,
                    color = Color.Gray
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}