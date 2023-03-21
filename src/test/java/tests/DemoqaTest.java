package tests;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.RegistrationResultsModal;
import utils.RandomStudent;

public class DemoqaTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    private final RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    RandomStudent randomStudent = new RandomStudent();

    @Test
    void fillFormTest() {
        String
                userFirstName = randomStudent.getRandomFirstName(),
                userLastName = randomStudent.getRandomLastName(),
                userEmail = randomStudent.getRandomEmail(),
                userGender = randomStudent.getRandomGender(),
                userPhone = randomStudent.getRandomPhone(),
                userBirthDay = randomStudent.getRandomBirthDay("day"),
                userBirthMonth = randomStudent.getRandomBirthDay("month"),
                userBirthYear = randomStudent.getRandomBirthDay("year"),
                userSubject = randomStudent.getRandomSubject(),
                userHobby = randomStudent.getRandomHobby(),
                userAddress = randomStudent.getRandomAddress(),
                userState = randomStudent.getRandomState(),
                userCity = randomStudent.getRandomCity(userState);
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
                .uploadFile(randomStudent.getFullName())
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
                .verifyResult("Picture", randomStudent.getFileName());
    }
}

