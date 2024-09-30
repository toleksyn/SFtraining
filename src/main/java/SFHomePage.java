import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

public class SFHomePage {
    public SFHomePage open() {
        Configuration.browser = "firefox";
//        Configuration.browser = "chrome";
        Configuration.timeout = 100 * 1000;
        Configuration.holdBrowserOpen = true;
        Selenide.open("https://www.shutterfly.com/");


//        try {                                            // solve problem with feedback popup !!!! ( not tested)
//            Selenide.$(".yrjS9gZCXQkP8g1fbNivy").click();
//        } catch (Exception e) {
//            System.out.println("Close button for feedback not found: " + e.getMessage());
//        }

        return this;
    }

    public void closeExtra15(){     // solve problem with Extra15 and Extra20 popups !
        Selenide.sleep(10 * 1000);
        if (Selenide.$x("//*[@id='boxclose']").is(Condition.visible)) {
            Selenide.$x("//*[@id='boxclose']").click();
        }
    }

    public SFHomePage signInDropdownOpen() {
        Selenide.$x("//header/div[5]/div[2]/ul[1]/li[1]/span[1]/span[1]/a[1]/span[1]")
                .click();
        return this;
    }

    public SFSignInPage signInClick() {
        Selenide.$x("//a[contains(text(),'Sign In')]")
                .click();
        return new SFSignInPage();
    }

    public AccountPage openAccountSettingsPage() {
        Selenide.$x("//a[contains(text(),'Account & Settings')]")
                .click();
        return new AccountPage();
    }

    public SFSignInPage signOutClick() {
        Selenide.$x("//a[contains(text(),'Sign Out')]")
                .click();
        return new SFSignInPage();
    }
}
