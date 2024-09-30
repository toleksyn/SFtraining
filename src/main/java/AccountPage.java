import com.codeborne.selenide.Selenide;
import static com.codeborne.selenide.Condition.text;

public class AccountPage {

    public void verifyUserSignedInAs(String email) {
        Selenide.$(".contact-info-section").shouldHave(text(email));
    }
}
