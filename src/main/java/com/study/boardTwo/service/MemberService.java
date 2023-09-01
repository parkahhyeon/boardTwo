package com.study.boardTwo.service;

import java.io.*;
import java.util.*;

public class MemberService {
    private static final String MEMBER_DATA_FILE = "members.txt";
    private static Map<String, String> memberData = new HashMap<>();

    static {
        loadMemberData();
    }

    public static boolean signUp(String username, String password) {
        if (!memberData.containsKey(username)) {
            memberData.put(username, password);
            saveMemberData();
            return true;
        }
        return false;
    }

    public static boolean login(String username, String password) {
        String storedPassword = memberData.get(username);
        return storedPassword != null && storedPassword.equals(password);
    }

    private static void loadMemberData() {
        try (BufferedReader reader = new BufferedReader(new FileReader(MEMBER_DATA_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    memberData.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void saveMemberData() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(MEMBER_DATA_FILE))) {
            for (Map.Entry<String, String> entry : memberData.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
