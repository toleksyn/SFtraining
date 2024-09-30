import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;

public class SFSignInPage {

    public SFHomePage signIn(String email, String password) {
        Selenide.$x("//*[@id='email']") //
                .setValue(email);
        Selenide.$x("//*[@id='password']") //
                .setValue(password);

        Selenide.$x("//button[contains(text(),'Sign In')]")
                .click();

        return new SFHomePage();
    }

    public void verifyUserSignedOut() {
        Selenide.$x("//*[@id='email']")
                .is(Condition.visible);
    }
}