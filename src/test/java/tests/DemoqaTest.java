package tests;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.RegistrationResultsModal;
import utils.RandomUser;

public class DemoqaTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    private final RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    RandomUser randomUser = new RandomUser();
    TestData testData = new TestData();

    @Test
    void fillFormTest() {
        String
                userFirstName = randomUser.getRandomFirstName(),
                userLastName = randomUser.getRandomLastName(),
                userEmail = randomUser.getRandomEmail(),
                userGender = randomUser.getRandomGender(),
                userPhone = randomUser.getRandomPhone(),
                userBirthDay = randomUser.getRandomBirthDay("day"),
                userBirthMonth = randomUser.getRandomBirthDay("month"),
                userBirthYear = randomUser.getRandomBirthDay("year"),
                userSubject = randomUser.getRandomSubject(),
                userHobby = randomUser.getRandomHobby(),
                userAddress = randomUser.getRandomAddress(),
                userState = randomUser.getRandomState(),
                userCity = randomUser.getRandomCity(userState);
        System.out.println(userBirthDay);

        registrationPage.openPage()
                .removeBanner()
                .setFirstName(userFirstName)
                .setLastName(userLastName)
                .setEmail(userEmail)
                .setGender(userGender)
                .setPhone(userPhone)
                .setBirthDate(userBirthDay, userBirthMonth, userBirthYear)
                .setSubject(userSubject)
                .setHobby(userHobby)
                .uploadFile(testData.userPicturePath)
                .setAddress(userAddress)
                .setState(userState)
                .setCity(userCity)
                .clickSubmit();

        registrationResultsModal.verifyModalAppears()
                .verifyResult("Student Name", userFirstName + " " + userLastName)
                .verifyResult("Student Email", userEmail)
                .verifyResult("Gender", userGender)
                .verifyResult("Mobile", userPhone)
                .verifyResult("Date of Birth", userBirthDay + " " + userBirthMonth + "," + userBirthYear)
                .verifyResult("Subjects", userSubject)
                .verifyResult("Hobbies", userHobby)
                .verifyResult("Address", userAddress)
                .verifyResult("State and City", userState + " " + userCity)
                .verifyResult("Picture", testData.userPictureName);
    }
}

