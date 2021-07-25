package com.company.commands;

import com.company.models.SessionManager;
import com.company.models.User;
import com.company.exceptions.AdminUserRequiredException;
import com.company.exceptions.CommandExecutionFailedException;
import com.company.exceptions.MemberRequiredException;
import com.company.exceptions.UserNotLoggedInException;

import java.util.Arrays;
import java.util.Optional;

public enum CLICommand
{
    LOGIN
            {
                @Override
                protected Command getCommand(String[] args)
                {
                    return new LoginCommand();
                }
            },
    LOGOUT
            {
                @Override
                protected Command getCommand(String[] args)
                {
                    return new LogoutCommand();
                }
            },
    INFO
            {
                @Override
                protected Command getCommand(String[] args)
                {
                    return new UserInfoCommand();
                }
            },
    REGISTER
            {
                @Override
                protected Command getCommand(String[] args)
                {
                    return new RegisterUserCommand();
                }
            },
    DELETE_ACCOUNT
            {
                @Override
                protected Command getCommand(String[] args)
                {
                    return new DeleteAccountCommand();
                }
            },
    SEARCH
            {
                @Override
                protected Command getCommand(String[] args)
                {
                    return new SearchProductsCommand();
                }
            },
    ADD_PRODUCT
            {
                @Override
                protected Command getCommand(String[] args)
                {
                    return new AddProductCommand();
                }
            },
    REMOVE_PRODUCT
            {
                @Override
                protected Command getCommand(String[] args)
                {
                    return new RemoveProductCommand();
                }
            },
    UPDATE_QTY
            {
                @Override
                protected Command getCommand(String[] args)
                {
                    return new UpdateQtyCommand();
                }
            },
    VIEW_CART
            {
                @Override
                protected Command getCommand(String[] args)
                {
                    return new ViewShoppingCartCommand();
                }
            },
    ADD_CART
            {
                @Override
                protected Command getCommand(String[] args)
                {
                    return new AddToCartCommand();
                }
            },
    REMOVE_CART
            {
                @Override
                protected Command getCommand(String[] args)
                {
                    return new RemoveFromCartCommand();
                }
            },
    CHECKOUT
            {
                @Override
                protected Command getCommand(String[] args)
                {
                    return new CheckoutCartCommand();
                }
            },
    ORDER_HISTORY
            {
                @Override
                protected Command getCommand(String[] args)
                {
                    return new ViewOrderHistoryCommand();
                }
            };

    protected abstract Command getCommand(String[] args);

    public void execute(String[] args)
    {
        try
        {
            Command command = getCommand(args);
            Optional<User> loggedInUser = SessionManager.getInstance().getLoggedInUser();
            if (command.requiresLoggedInUser() && !loggedInUser.isPresent())
            {
                throw new UserNotLoggedInException();
            }
            if (command.requiresMember() && !loggedInUser.get().isMember())
            {
                throw new MemberRequiredException();
            }
            if (command.requiresAdmin() && !loggedInUser.get().isAdmin())
            {
                throw new AdminUserRequiredException();
            }
            boolean result = command.execute(args);
            if (!result)
            {
                throw new CommandExecutionFailedException();
            }
        }
        catch (Exception e)
        {
            System.out.println("Error Occurred! - " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void execute(String command)
    {
        String[] commands = command.split(" ");
        if (commands.length == 0)
        {
            System.out.println("Invalid Command");
        }
        else if (commands[0].equalsIgnoreCase("exit"))
        {
            System.out.println("Shutting down system");
            System.exit(0);
        }
        else
        {
            Optional<CLICommand> commandOptional = Arrays.stream(CLICommand.values())
                    .filter(c -> c.name().equalsIgnoreCase(commands[0])).findFirst();
            if (!commandOptional.isPresent())
            {
                System.out.println("Invalid Command");
            }
            else
            {
                commandOptional.get().execute(commands);
            }
        }
    }
}
