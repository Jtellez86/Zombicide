package com.tom.zombie;

import com.tom.zombie.zombies.Zombie;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Zone {

    List<Survivor> survivors = new ArrayList<>();
    List<Zombie> zombies = new ArrayList<>();
}
