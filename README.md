# Login

Java user account application. Uses JavaFX to allow user signup and login via GUI.

## Getting Started

The following instructions will get Login up and running on your local machine for demonstration and testing purposes.

### Prerequisites

Assuming you have already cloned the project repository into your eclipse-workspace:

* Select the **File** > **Import**
* From the dropdown menu, select **Git** > **Projects from Git**
* Select **Next**, then **Existing local repository** from the dropdown menu on the next page
* Select **Next**, then the "CS-271" directory you cloned to the list
* Select **Next**, check **Import using the New Project Wizard**
* Select **Finsh**, another window should appear. Type "CS-271" in the project name and select **Finish**

A few errors appear in the project, don't panic! Expanding the working directory reveals that the test classes are the culprit. Hover over the junit import statement in any test case, you should be able to select **Fix project setup** which will immediately prompt you to add JUnit 3 to the build path.

### Installing

Right click the Welcome class, select **Run As** > **Configurations**. Add the Welcome class to the Java Application run configurations. Additionally add all of the test classes to the JUnit run configurations. Now, running the code should be as simple as pressing the green button.

## Running the tests

Unit tests are provided in src/tests. Running each class as a JUnit Test in eclipse provides the most insight.

### UserAccountTest

Tests most methods of the UserAccount class.

### UserAccountManagerTest

Runs 2 tests:

* Check to see if an existing account can be found in the manager.
* Check to see that an unregistered account does not return a false positive.

## Contributing

If you are unfamiliar with git (command line tool), download [Github Desktop Application](https://desktop.github.com/).

* Login to your github account in the application.
* Click **File** > **Clone**. If you do not see the "youngmamba8/CS-271" repository, accept your [invitation](https://github.com/youngmamba8/CS-271/invitations).
* Clone the repository into your eclipse-workspace directory.

You should now be able to edit the source code in the src folder after importing to eclipse (see installing).
When you make changes, commit with a comment. Then press the "push" button.

## Authors

* **Toby Bower** - *Initial work* [lukeblood](https://github.com/lukeblood)
* **Randy Camacho** - *Production classes* [youngmamba8](https://github.com/youngmamba8)
* **Brian Morck**
* **Quinn Shultz** - *Test classes and documentation* [quinnshultz](https://github.com/quinnshultz)
* **Connor Wood**

## Acknowledgments

* Provided starter files
