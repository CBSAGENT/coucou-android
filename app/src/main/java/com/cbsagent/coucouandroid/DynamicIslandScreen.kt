package com.cbsagent.coucouandroid

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cbsagent.coucouandroid.ui.theme.AccentAmber
import com.cbsagent.coucouandroid.ui.theme.AccentGreen
import com.cbsagent.coucouandroid.ui.theme.GlowBlue
import com.cbsagent.coucouandroid.ui.theme.GlowPurple
import com.cbsagent.coucouandroid.ui.theme.IslandBackground
import com.cbsagent.coucouandroid.ui.theme.IslandSoft
import com.cbsagent.coucouandroid.ui.theme.MochiDark
import com.cbsagent.coucouandroid.ui.theme.MochiSkin

private enum class IslandState {
    Compact,
    Expanded,
}

@Composable
fun DynamicIslandScreen() {
    var islandState by remember { mutableStateOf(IslandState.Compact) }

    val width by animateDpAsState(
        targetValue = if (islandState == IslandState.Expanded) 360.dp else 190.dp,
        animationSpec = tween(320),
        label = "islandWidth",
    )

    val height by animateDpAsState(
        targetValue = if (islandState == IslandState.Expanded) 188.dp else 42.dp,
        animationSpec = tween(320),
        label = "islandHeight",
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(IslandBackground),
        contentAlignment = Alignment.TopCenter,
    ) {
        Surface(
            modifier = Modifier
                .padding(top = 18.dp)
                .width(width)
                .height(height)
                .clickable { islandState = if (islandState == IslandState.Compact) IslandState.Expanded else IslandState.Compact },
            shape = RoundedCornerShape(28.dp),
            color = Color(0xFF0F1219),
            tonalElevation = 0.dp,
            shadowElevation = 12.dp,
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(
                                Color(0xFF161B25),
                                Color(0xFF0D1117),
                            ),
                        ),
                    ),
            ) {
                if (islandState == IslandState.Compact) {
                    CompactIslandContent()
                } else {
                    ExpandedIslandContent()
                }
            }
        }
    }
}

@Composable
private fun CompactIslandContent() {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            MochiFace(size = 26.dp)
            Box(modifier = Modifier.width(8.dp))
            Text(
                text = "Coucou",
                style = MaterialTheme.typography.labelLarge,
                color = Color.White.copy(alpha = 0.9f),
            )
        }

        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            Dot(color = AccentGreen)
            Dot(color = GlowBlue)
            Dot(color = AccentAmber)
        }
    }
}

@Composable
private fun ExpandedIslandContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 14.dp, vertical = 12.dp),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                MochiFace(size = 28.dp)
                Text(
                    text = "Claude Code",
                    modifier = Modifier.padding(start = 8.dp),
                    style = MaterialTheme.typography.labelLarge,
                    color = Color.White.copy(alpha = 0.9f),
                )
            }

            Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                Dot(color = AccentGreen)
                Dot(color = GlowPurple)
                Dot(color = AccentAmber)
            }
        }

        Box(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            ActivityPill("Apply", AccentGreen, true)
            ActivityPill("Review", GlowBlue, false)
            ActivityPill("Diff", AccentAmber, false)
        }

        Box(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = IslandSoft.copy(alpha = 0.9f),
                    shape = RoundedCornerShape(16.dp),
                )
                .padding(horizontal = 12.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Column {
                Text(
                    text = "Working on onboarding flow",
                    color = Color.White,
                    style = MaterialTheme.typography.bodyLarge,
                )
                Text(
                    text = "src/auth/OnboardingView.kt",
                    color = Color.White.copy(alpha = 0.7f),
                    style = MaterialTheme.typography.bodySmall,
                )
            }

            Box(
                modifier = Modifier
                    .size(30.dp)
                    .background(
                        color = AccentGreen.copy(alpha = 0.2f),
                        shape = CircleShape,
                    ),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = "✓",
                    color = AccentGreen,
                    fontSize = 14.sp,
                )
            }
        }
    }
}

@Composable
private fun ActivityPill(label: String, color: Color, active: Boolean) {
    Box(
        modifier = Modifier
            .background(
                color = if (active) color.copy(alpha = 0.22f) else Color.White.copy(alpha = 0.05f),
                shape = RoundedCornerShape(999.dp),
            )
            .padding(horizontal = 10.dp, vertical = 6.dp),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = label,
            color = if (active) color else Color.White.copy(alpha = 0.8f),
            style = MaterialTheme.typography.labelLarge,
        )
    }
}

@Composable
private fun Dot(color: Color) {
    Box(
        modifier = Modifier
            .size(7.dp)
            .background(color = color, shape = CircleShape),
    )
}

@Composable
private fun MochiFace(size: androidx.compose.ui.unit.Dp) {
    Canvas(modifier = Modifier.size(size)) {
        val radius = size.toPx() / 2f
        drawRoundRect(
            color = MochiSkin,
            size = Size(size.toPx(), size.toPx()),
            cornerRadius = CornerRadius(radius, radius),
        )

        val eyeSize = radius * 0.24f
        val eyeY = radius * 0.48f
        val leftX = radius * 0.54f
        val rightX = radius * 1.46f

        drawCircle(
            color = MochiDark,
            radius = eyeSize,
            center = Offset(leftX, eyeY),
        )
        drawCircle(
            color = MochiDark,
            radius = eyeSize,
            center = Offset(rightX, eyeY),
        )

        drawCircle(
            color = Color.White.copy(alpha = 0.9f),
            radius = eyeSize * 0.35f,
            center = Offset(leftX - 3f, eyeY - 2f),
        )
        drawCircle(
            color = Color.White.copy(alpha = 0.9f),
            radius = eyeSize * 0.35f,
            center = Offset(rightX - 3f, eyeY - 2f),
        )

        drawArc(
            color = MochiDark.copy(alpha = 0.84f),
            startAngle = 190f,
            sweepAngle = 160f,
            useCenter = false,
            style = Stroke(width = 2.2f),
            topLeft = Offset(radius * 0.28f, radius * 0.7f),
            size = Size(radius * 1.44f, radius * 0.72f),
        )
    }
}
