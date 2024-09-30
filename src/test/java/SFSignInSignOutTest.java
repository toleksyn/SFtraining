import org.testng.annotations.Test;
public class SFSignInSignOutTest {

    @Test
    public void verifySignInWorks() {
        var homePage = new SFHomePage().open();
        homePage.closeExtra15();
        SFSignInPage signInPage = homePage.signInDropdownOpen().signInClick();
        signInPage.signIn("testsf@g.com", "12345678s");

        // Verify that user is signed in
        AccountPage accountPage = homePage.signInDropdownOpen().openAccountSettingsPage();
        accountPage.verifyUserSignedInAs("testsf@g.com");

    }

    @Test
    public void verifySignOutWorks() {
        var homePage = new SFHomePage().open();
        homePage.closeExtra15();
        SFSignInPage signInPage = homePage.signInDropdownOpen().signOutClick();
        signInPage.verifyUserSignedOut();
    }
}
