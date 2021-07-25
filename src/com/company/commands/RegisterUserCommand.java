package com.company.commands;

import com.company.models.ContactInfo;
import com.company.models.Member;
import com.company.models.UserRegistry;

public class RegisterUserCommand extends AbstractOpenCommand
{
    @Override
    public boolean execute(String[] args)
    {
        if (args.length < 3) throw new IllegalArgumentException("Need atleast Name and Email Address");
        String name = args[1];
        String email = args[2];
        ContactInfo contactInfo = new ContactInfo(email, "", "");
        if (args.length > 3)
            contactInfo.setPhoneNumber(args[3]);
        if (args.length > 4)
            contactInfo.setAddress(args[4]);
        Member member = new Member(name, contactInfo);
        UserRegistry.getInstance().addUser(member);
        System.out.println("Registered user: " + member.getName());
        System.out.println("User ID of newly registed User: " + member.getUserId());
        return true;
    }
}
