package com.web.command.client;

import com.web.command.ActionCommand;
import com.web.command.impl.UserInfoCommand;
import com.web.command.impl.RedirectToSignUpCommand;
import com.web.command.impl.SignInCommand;
import com.web.command.impl.LogoutCommand;
import com.web.command.impl.RedirectToSignInCommand;
import com.web.command.impl.SignUpCommand;

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
