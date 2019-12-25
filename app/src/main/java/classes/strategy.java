package classes;

import com.example.recruitingsystem.R;

public class strategy {

    Login login;

    public strategy(int viewId) {
        if (viewId == R.id.signin)
        this.login = login;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }



}
