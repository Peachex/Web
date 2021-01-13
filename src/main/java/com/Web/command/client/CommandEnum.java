package com.Web.command.client;

import com.Web.command.ActionCommand;
import com.Web.command.impl.UserInfoCommand;
import com.Web.command.impl.RedirectToSignUpCommand;
import com.Web.command.impl.SignInCommand;
import com.Web.command.impl.LogoutCommand;
import com.Web.command.impl.RedirectToSignInCommand;
import com.Web.command.impl.SignUpCommand;

public enum CommandEnum {
    SIGN_IN {{
        this.command = new SignInCommand();
    }},
    LOGOUT {{
        this.command = new LogoutCommand();
    }},
    USER_INFO {{
        this.command = new UserInfoCommand();
    }},
    SIGN_UP {{
        this.command = new SignUpCommand();
    }},
    REDIRECT_TO_SIGN_IN {{
        this.command = new RedirectToSignInCommand();
    }},
    REDIRECT_TO_SIGN_UP {{
        this.command = new RedirectToSignUpCommand();
    }};

    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }
}
