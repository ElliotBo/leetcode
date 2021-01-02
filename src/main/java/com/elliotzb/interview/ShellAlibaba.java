package com.elliotzb.interview;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 阿里面试题：
 * 用hava实现cat webx.log  | grep "Login" | uniq -c | sort -nr的功能
 */
public class ShellAlibaba {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\webx.log");
        BufferedReader bf = new BufferedReader(new FileReader(file));
        List<String> lines = new ArrayList<String>();
        String line = null;
        while ((line = bf.readLine()) != null) {
            if (!"".equals(line.trim())){
                lines.add(line);
            }
        }
        lines = lines.stream().filter(r -> r.contains("Login")).collect(Collectors.toList());
        Map<String, Long> map = lines.stream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Set<String> nameSet = new HashSet<String>(lines);
        lines = nameSet.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        lines.stream().forEach(r->{
            System.out.print(map.get(r));
            System.out.print(" ");
            System.out.println(r);
        });
    }
}
