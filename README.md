# MobileTests

This repository contains automated UI tests for the **WEBDRIVER I/O** mobile application, implemented in Java using TestNG and Appium. The tests cover critical user flows to validate the app’s functionality and ensure its quality and stability.

## Project Requirements

To run these tests, you must:

- Install the APK of the WebDriver I/O dummy app on an Android device (Android Studio emulator or physical device).  
  You can download the APK from: [WebdriverIO Native Demo App Releases](https://github.com/webdriverio/native-demo-app/releases)  
  **Note:** Use the `.apk` file.
- (Optional) If you prefer to test on iOS, you will need a Mac device and the corresponding tools.
- Have Appium and the required Java/Maven dependencies configured.
- Each test scenario is fully independent, allowing them to be executed in any order and multiple times.

## Automated Scenarios

The following scenarios are automated according to the requirements of the final mobile automation practice:

1. **Navigation in the bottom menu bar**
   - Precondition: The user must be on the Home screen.
   - Navigate to each section by tapping its respective icon in the bottom menu.
   - Assertions are made to check that all elements in each section are correctly displayed (visibility and properties).

2. **Successful registration**
   - Precondition: The user must be in the Login section.
   - Navigate to the registration (Sign Up) view.
   - Complete the registration form (the test generates a random email for independence).
   - Verify that the registration process was successful.

3. **Successful login**
   - Precondition: The user must be in the Login section and a user must have been previously created.
   - Navigate to the Login view.
   - Complete the login form.
   - Verify that the login process was successful.

4. **Swipe in the Swipe section**
   - Precondition: The user must be in the Swipe section.
   - Swipe right on the cards and verify that the previous card is hidden.
   - Swipe to the last card and verify that only that one is visible.
   - Swipe vertically until you find the text "You found me!!!" and verify its visibility.

> **Important:**  
> The test cases are independent of each other (for example, the login test may reuse registration logic, but does not depend on the prior execution of the registration test).

## Project Structure

```
MobileTests/
├── .gitignore
├── .idea/
├── pom.xml
├── suite-full.xml
└── src/
    └── test/
        ├── java/
        │   └── com/
        │       └── globant/
        │           └── webdriver/
        │               ├── base/
        │               │   └── BaseTest.java
        │               ├── screens/
        │               │   ├── BaseScreen.java
        │               │   ├── DragScreen.java
        │               │   ├── FormsScreen.java
        │               │   ├── LoginScreen.java
        │               │   ├── SwipeScreen.java
        │               │   └── WebviewScreen.java
        │               ├── tests/
        │               │   └── Tests.java
        │               └── utils/
        │                   ├── AndroidOptions.java
        │                   ├── CredentialsFactory.java
        │                   └── DriverManager.java
        └── resources/
```

- `.gitignore`: Git file exclusions.
- `.idea/`: Project configuration for JetBrains IDEs (not relevant to the project logic).
- `pom.xml`: Maven configuration and dependencies file.
- `suite-full.xml`: TestNG suite for running tests.
- `src/test/java/`: Test source code, organized in packages.
    - `base/`: Base class for test setup.
    - `screens/`: Page Objects for app screens
    - `tests/`: Main automated tests class.
    - `utils/`: Utilities for options, credentials, and driver management
- `src/test/resources/`: Supporting resources for the tests (configuration files, data, etc).

## Technologies Used

| Dependency                                   | Version   | Purpose                                              |
|----------------------------------------------|-----------|------------------------------------------------------|
| io.appium:java-client                        | 9.2.2     | Appium client for mobile automation                  |
| org.seleniumhq.selenium:selenium-java        | 4.27.0    | Selenium WebDriver for test automation               |
| org.testng:testng                            | 7.10.2    | Main testing framework                               |
| Java                                         | 21        | Main programming language                            |
| Maven                                        | -         | Project build and dependency management              |

## Running the Tests

1. Clone the repository:

   ```sh
   git clone https://github.com/Macro1111/MobileTests.git
   ```

2. Install the necessary dependencies and configure Appium/Selenium according to your platform.

3. Run the tests using Maven or your favorite IDE:

   ```sh
   mvn test
   ```

Or you can run the specific suite:

   ```sh
   mvn -DsuiteXmlFile=suite-full.xml test
   ```

## Troubleshooting

If you encounter issues while setting up or running the tests, consider the following common problems and solutions:

- **Device/Emulator Not Detected**
  - Ensure that your Android emulator or device is running and recognized by your system:
    ```sh
    adb devices
    ```
  - Make sure the device is unlocked and USB debugging is enabled.

- **Appium Server Not Running**
  - Start the Appium server before executing the tests:
    ```sh
    appium
    ```
  - Ensure the server is listening on the default port (`4723`) or update your configuration accordingly.

- **Incorrect or Missing AndroidOptions Configuration**
  - The tests rely on the correct configuration provided by the `AndroidOptions` utility class (`src/test/java/com/globant/webdriver/utils/AndroidOptions.java`).
  - Make sure that the following are set correctly in the `getAndroidOptions()` method:
    - `.setDeviceName(...)`: Your actual Android device name or emulator name (e.g., `"emulator-5554"` or `"YOUR_DEVICE_NAME"`).
    - `.setApp(...)`: Absolute path to the downloaded APK file (e.g., `"/path/to/your/android.wdio.native.app.v1.0.8.apk"`).
    - `.setAppPackage("com.wdiodemoapp")`: The correct package name for the WDIO demo app.
    - `.setAppActivity(".MainActivity")`: The correct main activity for the app.
  - **Example (generic):**
    ```java
    public static UiAutomator2Options getAndroidOptions() {
        return new UiAutomator2Options()
                .setDeviceName("emulator-5554")
                .setApp("/path/to/your/android.wdio.native.app.v1.0.8.apk")
                .setAppPackage("com.wdiodemoapp")
                .setAppActivity(".MainActivity");
    }
    ```
  - If you change your device, APK path, or environment, update these values accordingly.

- **APK Not Installed/Not Found**
  - Ensure the APK path in your configuration is correct and the file is accessible.
  - If running on an emulator, the emulator must be running before starting the test.

- **Port Conflicts**
  - If Appium fails to start or bind, check that port `4723` is not in use by another process.

- **Java/Maven Issues**
  - Make sure you are using Java 21 and a compatible Maven version.
  - Run `mvn clean install` to refresh dependencies if you encounter build errors.

- **General Advice**
  - Check the logs in the console and the `target/surefire-reports` directory for detailed error messages.
  - Restart your emulator/device and Appium server if issues persist.

If you encounter other problems not listed here, please review the stack trace and configuration files for clues. You can also check [Appium Documentation](https://appium.io/docs/en/2.0/intro/).

## Author

**Macro1111**

## License

[MIT](LICENSE)
