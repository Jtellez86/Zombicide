package com.tom.zombie.util;

import com.tom.zombie.Dice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WeaponDamageCalculatorTest {

    @Mock
    Dice dice;

    @InjectMocks
    WeaponDamageCalculator calculator = new WeaponDamageCalculator();

    @Test
    public void shouldCalculateDamageForSuccessfulPanAttack() {
        when(dice.roll(1)).thenReturn(asList(6));

        assertThat(calculator.calculateDamageFromRoll(1, 6, 1),is(asList(1)));
    }

    @Test
    public void shouldCalculateDamageForFailedPanAttack() {
        when(dice.roll(1)).thenReturn(asList(1));

        assertThat(calculator.calculateDamageFromRoll(1, 6, 1).isEmpty(),is(true));
    }

    @Test
    public void shouldCalculateDamageForSuccessKatanaAttack() {
        when(dice.roll(2)).thenReturn(asList(6, 6));

        assertThat(calculator.calculateDamageFromRoll(2, 4, 1),is(asList(1, 1)));
    }

    @Test
    public void shouldCalculateDamageForFailedKatanaAttack() {
        when(dice.roll(2)).thenReturn(asList(1, 1));

        assertThat(calculator.calculateDamageFromRoll(2, 4, 1).isEmpty(),is(true));
    }

}