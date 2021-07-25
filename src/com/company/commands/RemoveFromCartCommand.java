package com.company.commands;

import com.company.models.Member;

public class RemoveFromCartCommand extends AbstractMemberCommand
{
    @Override
    public boolean execute(String[] args)
    {
        Member member = (Member) getLoggedInUser();
        member.removeProductFromCart(args[1], Integer.parseInt(args[2]));
        return new ViewShoppingCartCommand().execute(args);
    }
}
