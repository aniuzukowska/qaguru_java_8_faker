package tests;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.RegistrationResultsModal;
import utils.RandomUtils;

public class DemoqaTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    private final RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    RandomUtils randomUtils = new RandomUtils();

    @Test
    void fillFormTest() {
        String
                userFirstName = randomUtils.getRandomFirstName(),
                userLastName = randomUtils.getRandomLastName(),
                userEmail = randomUtils.getRandomEmail(),
                userGender = randomUtils.getRandomGender(),
                userPhone = randomUtils.getRandomPhone(),
                userBirthDay = randomUtils.getRandomBirthDay(),
                userBirthMonth = randomUtils.getRandomBirthMonth(),
                userBirthYear = randomUtils.getRandomBirthYear(),
                userSubject = randomUtils.getRandomSubject(),
                userHobby = randomUtils.getRandomHobby(),
                userAddress = randomUtils.getRandomAddress(),
                userState = randomUtils.getRandomState(),
                userCity = randomUtils.getRandomCity(userState),
                userPicture = "picture.jpg";

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
                .uploadFile("img/"+userPicture)
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
                .verifyResult("Picture", userPicture);
    }
}

