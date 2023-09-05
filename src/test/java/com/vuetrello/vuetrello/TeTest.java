package com.vuetrello.vuetrello;

import java.awt.*;

import org.junit.jupiter.api.Test;

public class TeTest {
	@Test
	void contextLoads() {
		Color a = new Color((int)(Math.random() * 0x1000000));
		System.out.println(a.getRGB());
		String b = String.format("#%02x%02x%02x", a.getRed(), a.getGreen(), a.getBlue());
		System.out.println(b);
	}
}
