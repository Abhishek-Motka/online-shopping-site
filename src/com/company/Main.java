package com.company;

import com.company.commands.CLICommand;
import com.company.models.Admin;
import com.company.models.ContactInfo;
import com.company.models.UserRegistry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main
{
    public static void main(String[] args)
    {
        ContactInfo adminContactInfo =  new ContactInfo("admin@system.com", "88866628217", "Mumbai");
        Admin admin = new Admin("Admin", adminContactInfo);
        UserRegistry.getInstance().addUser(admin);
        System.out.println("Admin userid: " + admin.getUserId());

        try (InputStreamReader inputStreamReader = new InputStreamReader(System.in);
             BufferedReader reader = new BufferedReader(inputStreamReader)) {
            while (true)
            {
                System.out.print("Enter command: ");
                String line = reader.readLine();
                CLICommand.execute(line);
            }
        }
        catch (IOException e)
        {
            System.out.println("Encountered error while getting input from user");
            System.exit(1);
        }
    }
}
