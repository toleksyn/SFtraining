import org.testng.annotations.Test;

public class SFSignInSignOutTest {

    @Test
    public void verifySignInWorks() {
        var homePage = new SFHomePage()
            .open()
            .closeExtraPopup();

        var username = "testsf@g.com";
        homePage.signIn(username, "12345678s"); // openDropDown().signIn();
        
        logginInPage
            .openAccountSettingsPage(); // .signInDropdownOpen() 
            .verifyUserSignedInAs(username);
    }

    @Test
    public void verifySignOutWorks() {
        var homePage = new SFHomePage().open();
        homePage.closeExtra15();
        SFSignInPage signInPage = homePage.signInDropdownOpen().signOutClick();
        signInPage.verifyUserSignedOut();
    }
}
