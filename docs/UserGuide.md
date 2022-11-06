---
layout: page
title: User Guide
---

DevEnable is a **desktop app for developers to manager their projects, optimized for use via a Command Line Interface** (CLI) while still having the benefits of a Graphical User Interface (GUI). If you can type fast, DevEnable can get your project management tasks done faster than traditional GUI apps.

* Table of Contents
{:toc}

--------------------------------------------------------------------------------------------------------------------

# Quick start

1. Ensure you have Java `11` or above installed in your Computer.

2. Download the latest `devenable.jar`.

3. Copy the file to the folder you want to use as the _home folder_ for DevEnable.

4. Double-click the file to start the app.

5. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

   * **`project -l`** : Lists all projects.

   * **`project -a`**`n/Orbital` : Adds a project named `Orbital` to the project list.

   * **`project -d`**`3` : Deletes the project with project id `3`.

   * **`clear`** : Deletes all data from all lists.

6. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

# Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Commands are in the following format: `COMMAND FLAG [ID/ARGUMENTS]*`. Every command starts with a command keyword, followed by the command flag, then the arguments for said command. Typically, flags start with a dash `-`, and arguments start with an identifier `ID/ARGUMENT`.
* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `project -a n/PROJECT_NAME`, `PROJECT_NAME` is a parameter which can be used as `project -a n/PROJECT_NAME`.

* Items in square brackets are optional.<br>
  e.g. `n/PROJECT_NAME [r/REPOSITORY]` can be used as `project -a n/ProjectY r/AgentX/ProjectY`.

* Parameters can be in any order.<br>
  e.g. if the command specifies `client -a p/PROJECT_ID n/CLIENT_NAME [m/CLIENT_MOBILE] [e/CLIENT_EMAIL]`, `client -a p/PROJECT_ID n/CLIENT_NAME [e/CLIENT_EMAIL] [m/CLIENT_MOBILE]` are both acceptable.

* If a parameter is expected only once in the command, but you specified it multiple times, only the last occurrence 
  of the parameter will be taken. (Does not apply for Find and Sort Commands) <br>
  e.g. if you specify `m/12341234 m/56785678`, only `m/56785678` will be taken.

* Extraneous parameters for commands that do not take in parameters (such as `help`, `exit` and `clear`) will be ignored.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`.

* Trailing extraneous input for commands that take in parameters will be considered a part of the last valid 
  argument identifier unless the argument identifier takes in an index parameter .
  e.g. if the command specifies `project -e n/New Project x/this is extra`, `New Project x/this is extra` will be 
  taken as the argument for `n/` but if the command specifies `project -e n/New Project p/2 x/this is extra`, then 
  only `2` will be taken as the argument for `p/`.

</div>

## General Commands

### Viewing help : `help`

Displays a list of commands and functionalities.

Format: `help`

### Clearing all entries : `clear`

Clears all entries from the list. 

Format: `clear`

## Project Commands

> NOTE: Clicking the Repository Link of a project will copy it to the clipboard

### Adding a project: `project -a`

Adds a project to the AddressBook. A unique project ID will be automatically generated.

![add project command](images/AddProjectCommand.png)

Format: `project -a n/PROJECT_NAME [r/REPOSITORY] [c/CLIENT_ID] [d/DEADLINE]`

* Adds the project to the list of projects.
* `PROJECT_NAME` must only contain alphanumeric characters (cannot be empty or start with a space).
* `REPOSITORY` must be in the format USERNAME/REPO_NAME.
* `CLIENT_ID` must exist and be a positive integer (1, 2, 3 ...​).
* `DEADLINE` must be in the format yyyy-mm-dd.

Examples:
* `project -a n/Coding101` Adds a project with `PROJECT_NAME` Coding101 to the `ProjectList`.
* `project -a n/MyFavProject r/Jeff/MyFavProject` Adds a project with `PROJECT_NAME` MyFavProject and 
`REPOSITORY` Jeff/MyFavProject to the `ProjectList`.
* `project -a n/AnotherProject c/1` Adds a project with `PROJECT_NAME` AnotherProject to the `ProjectList` and adds a
client with `CLIENT_ID` 1 to the project.
* `project -a n/OneMoreProject c/1 d/2022-03-07` Adds a project with `PROJECT_NAME` OneMoreProject and `PROJECT_DEADLINE`
2022-03-07 to the `ProjectList` and adds a client with `CLIENT_ID` 1 to the project.
* `project -a n/LastProject d/2023-10-01 r/Dave/LastProject c/2` Adds a project with `PROJECT_NAME` LastProject and 
`DEADLINE` 2023-10-01 and `REPOSITORY` Dave/LastProject to the `ProjectList` and adds a client with `CLIENT_ID` 2 
to the project.

### Editing a project : `project -e`

Edits a specified existing project.

![edit_project_command](images/EditProjectCommand.png)

Format: `project -e p/PROJECT_ID [n/PROJECT_NAME] [r/REPOSITORY] [c/CLIENT_ID] [d/DEADLINE]`

* Edits the project with the specified `PROJECT_ID`. The ID refers to the unique ID generated upon adding a project.
  The ID **must exist and be a positive integer** 1, 2, 3, …​
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.

Examples:
* `project -e p/1 n/FirstProject` Edits the project with `PROJECT_ID` 1 to have the new `PROJECT_NAME` FirstProject.
* `project -e p/2 r/James/SecondProject` Edits the project with `PROJECT_ID` 2 to have the new `REPOSITORY` 
James/SecondProject.
* `project -e p/3 c/1 d/2021-12-03` Edits the project with `PROJECT_ID` 3 to have the new client with `CLIENT_ID` 1 
and new `DEADLINE` 2021-12-03.
* `project -e p/4 n/ThirdProject d/2022-02-02 r/Jackson/ThirdProject c/2` Edits the project with `PROJECT_ID` 4 to 
have the new `PROJECT_NAME` ThirdProject, new `DEADLINE` 2022-02-02, new `REPOSITORY` Jackson/ThirdProject and new 
client with `CLIENT_ID` 2.

### Deleting a project : `project -d`

Removes the specified existing project.

![delete_project_command](images/DeleteProjectCommand.png)
Format: `project -d PROJECT_ID`

* Deletes the project with the specified `PROJECT_ID`.
* The ID **must exist and be a positive integer** 1, 2, 3, …​

Examples:
* `project -d 1` Deletes project with `PROJECT_ID` 1.
* `project -d 4` Deletes project with `PROJECT_ID` 4.

### Listing all projects : `project -l`

Shows a list of all projects.

Format: `project -l`

### Finding a project : `project -f`

Finds and lists all the projects matching the search criteria.

![find project command](images/FindProjectCommand.png)

Format: `project -f [n/PROJECT_NAME] [p/PROJECT_ID] [r/REPOSITORY] [l/CLIENT_LABEL] [c/CLIENT_ID]`

* Finds all the projects with the specified `PROJECT_NAME`, `PROJECT_ID`, `REPOSITORY`, `CLIENT_LABEL` and 
  `CLIENT_ID`. The `CLIENT_LABEL` is the name of the project's client, appearing as a label on the project card.
* Finds all the projects such that the fields under the project contain at least one word from the keywords provided
  after each search criteria if the search criteria is project or client name.
* At least one of the optional fields must be provided.
* The keywords provided must be valid arguments for their respective search criteria.

Examples:
* `project -f n/DevEnable` Finds and lists all the projects whose `PROJECT_NAME` contains the word DevEnable.
* `project -f n/DevEnable AB3` Finds and lists all the projects whose `PROJECT_NAME` contains the word DevEnable or AB3.
* `project -f r/tp/F13` Finds and lists all the projects with the `REPOSITORY` tp/F13.
* `project -f l/Amy l/Ben` Finds and lists all the projects with the client whose `CLIENT_NAME` is Amy or Ben.
* `project -f c/3` Finds and lists all the projects with the client whose `CLIENT_ID` is 3.
* `project -f p/1` Finds and lists the project with `PROJECT_ID` 1.
* `project -f n/AB4 AB3 r/tp/F13` Finds and lists all the projects whose `PROJECT_NAME` contains the word AB4 or AB3 
  and with the `REPOSITORY` tp/F13.

### Pin a project: `project -p`

Pins a project to the top of the project list.

![pin_project_command](images/PinProjectCommand.png)

Format: `project -p PROJECT_ID`

* Pins the project with the specified `PROJECT_ID`.
* Executing the command on an already pinned project will unpin the project.
* The ID **must be a positive integer** 1, 2, 3, …​

Examples:
* `project -p 1` Pins the project with `PROJECT_ID` 1.
* `project -p 4` Pins the project with `PROJECT_ID` 4.

### Sorting all projects: `project -s`

Sorts all projects based on a specified key.

![sort_project_command](images/SortProjectCommand.png)

Format: `project -s [p/PROJECT_ID] [d/DEADLINE] [i/ISSUE_COUNT] [n/PROJECT_NAME]`

* Exactly one optional value (the prefix/the sorting key) is to be provided 
(Command will not accept multiple optional values).
* Input 0/1 for each Prefix (e.g. p/0):
  * For `PROJECT_ID`, 0 for ascending and 1 for descending.
  * For `DEADLINE`, 0 for chronological and 1 for reverse chronological.
  * For `ISSUE_COUNT`, 0 for incomplete issues and 1 for completed issues.
  * For `PROJECT_NAME`, 0 for alphabetical and 1 for reverse alphabetical.

Examples:
* `project -s p/1` Sorts list of projects based on `PROJECT_ID` from highest to lowest.
* `project -s d/0` Sorts list of projects based on `DEADLINE` from earliest to latest.
* `project -s i/0` Sorts list of projects based on `ISSUE_COUNT` from the highest incomplete issue count to the lowest.
* `project -s n/0` Sorts list of projects based on `PROJECT_NAME` in alphabetical order.


### Setting project list as default view: `project -v`

Sets list of projects to be the default view when application is re-opened.

Format: `project -v`

## Client Commands

### Adding a client : `client -a`

Adds a client to the AddressBook. A unique client ID will be automatically generated. 

![add client command](images/AddClientCommand.png)

Format: `client -a n/CLIENT_NAME p/PROJECT_ID [m/CLIENT_MOBILE] [e/CLIENT_EMAIL]`

* Adds the client to the list of clients and to the project with the specified `PROJECT_ID`.
* `CLIENT_NAME` must only contain alphanumeric characters (cannot be empty or start with a space).
* `PROJECT_ID` must exist and be a positive integer (1, 2, 3 ...​).
* `CLIENT_MOBILE` must only contain numbers and must be more than 3 digits long such that any number with a country 
  code can be added without any prefix or connecting symbol.
* `CLIENT_EMAIL` must be in the format LOCAL_NAME@DOMAIN_NAME.com (local name must be longer than 3 characters).

Examples:
*  `client -a n/Amy p/1` Adds a client with `CLIENT_NAME` Amy to the `ClientList` and to the project with 
   `PROJECT_ID` 1.
*  `client -a n/Bob p/2 m/12345678` Adds a client with `CLIENT_NAME` Bob and `CLIENT_MOBILE` 12345678 to the 
   `ClientList` and to the project with `PROJECT_ID` 2.
*  `client -a n/Charlie e/charlie@gmail.com p/3` Adds a client with `CLIENT_NAME` Charlie and `CLIENT_EMAIL` 
   charlie@gmail.com to the `ClientList` and to the project with `PROJECT_ID` 3.
*  `client -a n/Dave m/12345678 e/dave@gmail.com p/4` Adds a client with `CLIENT_NAME` Dave, `CLIENT_MOBILE` 
   12345678 and `CLIENT_EMAIL` dave@gmail.com to the `ClientList` and to the project with `PROJECT_ID` 4.

### Editing a client : `client -e`

Edits the specified existing client.

![edit client command](images/EditClientCommand.png)

Format: `client -e c/CLIENT_ID [n/CLIENT_NAME] [m/CLIENT_MOBILE] [e/CLIENT_EMAIL]`

* Edits the client with the specified `CLIENT_ID`. The ID refers to the unique ID generated upon adding a client. The ID
**must exist and be a positive integer** 1, 2, 3, ...
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.

Examples:
*  `client -e c/1 n/Amy` Edits the client with `CLIENT_ID` 1 to have the new `CLIENT_NAME` Amy.
*  `client -e c/2 n/Bob m/12345678` Edits the client with `CLIENT_ID` 2 to have the new `CLIENT_NAME` Bob 
   and `CLIENT_MOBILE` 91234567.
*  `client -e c/3 n/Charlie e/charlie@gmail.com` Edits the client with `CLIENT_ID` 3 to have the new 
   `CLIENT_NAME` Charlie and `CLIENT_EMAIL` charlie@gmail.com.
*  `client -e c/4 n/Dave m/12345678 e/dave@gmail.com` Edits the client with `CLIENT``_ID` 4 to have the new 
   `CLIENT_NAME` Dave, `CLIENT_MOBILE` 12345678 and `CLIENT_EMAIL` dave@gmail.com.

### Deleting a client : `client -d`

Removes the specified existing client.

![delete client command](images/DeleteClientCommand.png)

Format: `client -d CLIENT_ID`

* Deletes the client with the specified `CLIENT_ID`.
* The ID **must exist and be a positive integer** 1, 2, 3, …​

Examples:
* `client -d 1` Deletes client with `CLIENT_ID` 1.
* `client -d 6` Deletes client with `CLIENT_ID` 6.

### Listing all clients : `client -l`

Shows a list of all clients. 

Format: `client -l`

### Finding a client : `client -f`

Finds and lists all the clients matching the search criteria.

![find client command](images/FindClientCommand.png)

Format: `client -f [n/CLIENT_NAME] [c/CLIENT_ID] [e/CLIENT_EMAIL] [m/CLIENT_MOBILE]`

* Finds all the clients with the specified `CLIENT_NAME`, `CLIENT_ID`, `CLIENT_EMAIL`, and `CLIENT_MOBILE`.
* Finds all the clients such that the fields under the client contain at least one word from the keywords provided 
  after each search criteria if the search criteria is client name.
* At least one of the optional fields must be provided.
* The keywords provided must be valid arguments for their respective search criteria.

Examples:
* `client -f n/Amy` Finds and lists all the clients whose `CLIENT_NAME` contains the word Amy.
* `client -f c/1` Finds and lists the client whose `CLIENT_ID` is 1.
* `client -f n/Amy Bob` Finds and lists all the clients with the `CLIENT_NAME` contains the word Amy or Bob.
* `client -f n/Amy e/amy@gmail.com e/amycarter@gmail.com` Finds and lists all the clients whose `CLIENT_NAME` contains 
  the word Amy and with `CLIENT_EMAIL` amy@gmail.com or amycarter@gmail.com.
* `client -f n/Amy e/amy@gmail.com m/12345678` Finds and lists all the clients whose `CLIENT_NAME` contains the word 
  Amy and with `CLIENT_EMAIL` amy@gmail.com and with `CLIENT_MOBILE` 12345678.
* `client -f n/Amy Bob e/amy@gmail.com e/bobamy@gmail.com m/12345678` Finds and lists all the clients whose 
  `CLIENT_NAME` contains the word Amy or Bob and with `CLIENT_EMAIL` amy@gmail.com or bobamy@gmail.com and with 
  `CLIENT_MOBILE` 12345678.

### Pin a client: `client -p`

Pins a client to the top of the client list.

![pin_client_command](images/PinClientCommand.png)

Format: `client -p CLIENT_ID`

* Pins the client with the specified `CLIENT_ID`.
* Executing the command on an already pinned client will unpin the client.
* The ID **must be a positive integer** 1, 2, 3, …​

Examples:
* `client -p 1` Pins the client with `CLIENT_ID` 1.
* `client -p 4` Pins the client with `CLIENT_ID` 4.

### Sorting all clients: `client -s`

Sorts all clients based on a specified key.

![sort_client_command](images/SortClientCommand.png)

Format: `client -s [c/CLIENT_ID] [n/CLIENT_NAME]`

* Exactly one optional value (sorting key) to be provided 
(Command will not accept multiple optional values).
* Input 0/1 for each Prefix (e.g. c/1):
  * For `CLIENT_ID`, 0 for ascending and 1 for descending.
  * For `CLIENT_NAME`, 0 for alphabetical and 1 for reverse alphabetical

Examples:
* `client -s c/0` Sort list of clients based on `CLIENT_ID` from lowest to highest.
* `client -s n/1` Sort list of clients based on `CLIENT_NAME` in reverse alphabetical order.

### Setting client list as default view: `client -v`

Sets list of clients to be the default view when application is re-opened.

Format: `client -v`

## Issue Commands

> NOTE: Multiple issues can have the exact same fields (other than the issue id), as it is possible for a project to 
> have multiple of the same issues.

### Adding an issue : `issue -a`

Adds an issue to the AddressBook. A unique issue ID will be automatically generated. 

![add_issue_command](images/AddIssueCommand.png)

Format: `issue -a p/PROJECT_ID t/TITLE [d/DEADLINE] [u/URGENCY]`

* Adds the issue to the overall list of issues and to the list of issues of the project with the specified `PROJECT_ID`.
* `PROJECT_ID` must exist and be a positive integer (1, 2, 3 ...​)
* `TITLE` cannot be empty or start with a space
* `DEADLINE` must be in the format yyyy-mm-dd
* `URGENCY` must be an integer from 0 to 3, 0 for NONE, 1 for LOW, 2 for MEDIUM and 3 for HIGH

Examples:
* `issue -a p/1 t/Fix Ui` Adds an issue with `TITLE` Fix Ui to the overall `IssueList` and to the `IssueList` of the 
project with `PROJECT_ID` 1.
* `issue -a p/2 t/Add tests u/2`Adds an issue with `TITLE` Add tests and `URGENCY` MEDIUM(2) to the overall `IssueList`
and to the `IssueList` of the project with `PROJECT_ID` 2.
* `issue -a t/Design GUI u/0 d/2022-09-12 p/3` Adds an issue with `TITLE` Design GUI, `URGENCY` NONE(0) and `DEADLINE` 
2022-09-12 to the overall `IssueList` and to the `IssueList` of the project with `PROJECT_ID` 3.

### Editing an issue : `issue -e`

Edits the specified existing issue. 

![edit_issue_command](images/EditIssueCommand.png)

Format: `issue -e i/ISSUE_ID [t/TITLE] [d/DEADLINE] [u/URGENCY]`

* Edits the issue with the specified `ISSUE_ID` The ID refers to the unique ID generated upon adding an issue. The ID 
**must exist in issue list and be a positive integer** 1, 2, 3, ...
* At least one of the optional fields must be provided.
* Existing values will be updated to the input value.
* `PROJECT_ID` cannot be edited as each issue is created for a specific project
* `DEADLINE` must be in the format yyyy-mm-dd
* `URGENCY` must be an integer from 0 to 3, 0 for NONE, 1 for LOW, 2 for MEDIUM and 3 for HIGH

Examples:
* `issue -e i/1 t/Do DG` Edits the issue with `ISSUE_ID` 1 to have the new `TITLE` Do DG.
* `issue -e i/2 d/2021-12-20 u/1` Edits the issue with `ISSUE_ID` 2 to have the new `DEADLINE` 2021-12-20 and `URGENCY`
LOW(1).
* `issue -e 1/3 u/3 t/Do UG d/2022-01-12` Edits the issue with `ISSUE_ID` 3 to have the new `URGENCY` HIGH(3) and 
`TITLE` Do UG and `DEADLINE` 2022-01-12.

### Deleting an issue : `issue -d`

Removes the specified existing issue.

![delete_issue_command](images/DeleteIssueCommand.png)

Format: `issue -d ISSUE_ID`

* Deletes the issue with the specified `ISSUE_ID`.
* The ID **must exist and be a positive integer** 1, 2, 3, …​

Examples:
* `issue -d 1` Deletes issue with `ISSUE_ID` 1.
* `issue -d 3` Deletes issue with `ISSUE_ID` 3.

### Listing all issues : `issue -l`

Shows a list of all issues.

Format: `issue -l`

### Finding an issue : `issue -f`

Finds and lists all the issues matching the search criteria.

![find issue command](images/FindIssueCommand.png)

Format: `issue -f [t/TITLE] [s/STATUS] [u/URGENCY] [n/PROJECT_NAME] [p/PROJECT_ID] [i/ISSUE_ID]`

* Finds all the issues with the specified `TITLE`, `STATUS`, `URGENCY`, `PROJECT_NAME`, `PROJECT_ID` and `ISSUE_ID`.
* Finds all the issues such that the fields under the issue contain at least one word from the keywords provided
  after each search criteria if the search criteria is title or project name.
* At least one of the optional fields must be provided.
* The keywords provided must be valid arguments for their respective search criteria.

Examples:
* `issue -f n/DevEnable` Finds and lists all the issues tied to the project with `PROJECT_NAME` containing DevEnable.
* `issue -f n/DevEnable AB3` Finds and lists all the issues tied to the project with `PROJECT_NAME` containing 
  DevEnable or AB3.
* `issue -f i/3` Finds and lists the issue with `ISSUE_ID` 3.
* `issue -f p/3 p/5` Finds and lists the issue tied to project with `PROJECT_ID` 3 or 5.
* `issue -f n/DevEnable AB3 u/LOW` Finds and lists all the issues with `URGENCY` as LOW and tied to the project with 
  `PROJECT_NAME` containing DevEnable or AB3.
* `issue -f t/enhancement p/DevEnable AB3 u/HIGH u/LOW` Finds and lists all the issues with `TITLE` enhancement and 
  `URGENCY` HIGH or LOW and tied to project with `PROJECT_NAME` containing DevEnable or AB3.
* `issue -f s/Incomplete` Finds and lists all the issues with the `STATUS` Incomplete.

### Pin an issue: `issue -p`

Pins an issue to the top of the issue list.

![pin_issue_command](images/PinIssueCommand.png)

Format: `issue -p ISSUE_ID`

* Pins the issue with the specified `ISSUE_ID`. 
* Executing the command on an already pinned issue will unpin the issue.
* The ID **must be a positive integer** 1, 2, 3, …​

Examples:
* `issue -p 1` Pins the issue with `ISSUE_ID` 1.
* `issue -p 4` Pins the issue with `ISSUE_ID` 4.

### Sorting all issues: `issue -s`

Sorts all issues based on a specified key.

![sort_issue_command](images/SortIssueCommand.png)

Format: `issue -s [i/ISSUE_ID] [d/DEADLINE] [u/URGENCY]`

* Exactly one optional value (sorting key) to be provided 
(Command will not accept multiple optional values).
* Input 0/1 for each Prefix (e.g. i/0):
  * For `ISSUE_ID`, 0 for ascending and 1 for descending.
  * For `DEADLINE`, 0 for chronological and 1 for reverse chronological.
  * For `URGENCY`, 0 for ascending and 1 for descending.

Examples: 
* `issue -s i/0` Sorts list of issues based on `ISSUE_ID` from lowest to highest.
* `issue -s d/0` Sorts list of issues based on `DEADLINE` from earliest to latest.
* `issue -s u/1` Sorts list of issues based on `URGENCY` from highest to lowest.

### Marking an issue: `issue -m`
 
Marks specified existing issue as completed.

![mark_issue_command](images/MarkIssueCommand.png)

Format: `issue -m ISSUE_ID`

* Marks the issue with the specified `ISSUE_ID`, changing its `STATUS` to completed.
* If issue is already marked completed, it remains completed.
* The ID **must exist and be a positive integer** 1, 2, 3, …​

Examples:
* `issue -m 1` Changes the `STATUS` of the issue with `ISSUE_ID` 1 to completed.
* `issue -m 8` Changes the `STATUS` of the issue with `ISSUE_ID` 8 to completed.

### Unmarking an issue: `issue -u`

![unmark_issue_command](images/UnmarkIssueCommand.png)

Marks specified existing issue as incomplete.

Format: `issue -u ISSUE_ID`

* Unmarks the issue with the specified `ISSUE_ID`, changing its `STATUS` to incomplete.
* If issue is already marked incomplete, it remains incomplete.
* The ID **must exist and be a positive integer** 1, 2, 3, …​

Examples:
* `issue -m 1` Changes the `STATUS` of the issue with `ISSUE_ID` 1 to incomplete.
* `issue -m 4` Changes the `STATUS` of the issue with `ISSUE_ID` 4 to incomplete.

### Setting issue list as default view: `issue -v`
 
Sets list of issues to be the default view when application is re-opened.

Format: `issue -v`

## Others

### Saving the data

DevEnable data is saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

### Editing the data file

DevEnable data is saved as a JSON file `[JAR file location]/data/addressbook.json`. Advanced users are welcome to update data directly by editing that data file.

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
If your changes to the data file makes its format invalid, DevEnable will discard all data and start with an empty data file at the next run.
</div>

--------------------------------------------------------------------------------------------------------------------

# FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the data file it creates with the file that contains the data of your previous DevEnable home folder.

--------------------------------------------------------------------------------------------------------------------

# Command summary

| Action                         | Format                                                                          |
|--------------------------------|:-------------------------------------------------------------------------------------------|
| **Add Project**                | `project -a n/PROJECT_NAME [r/REPOSITORY] [c/CLIENT_ID] [d/DEADLINE] `                     |
| **Edit Project**               | `project -e p/PROJECT_ID [n/PROJECT_NAME] [r/REPOSITORY] [c/CLIENT_ID] [d/DEADLINE]`       |
| **Delete Project**             | `project -d PROJECT_ID`                                                                    |
| **List Projects**              | `project -l`                                                                               |
| **Find Projects**              | `project -f [n/PROJECT_NAME] [r/REPOSITORY] [p/PROJECT_ID] [c/CLIENT_ID] [l/CLIENT_LABEL]` |
| **Pin Projects**               | `project -p PROJECT_ID`                                                                    |
| **Sort Projects**              | `project -s [p/PROJECT_ID] [d/DEADLINE] [i/ISSUE_COUNT] [n/PROJECT_NAME]`                  |
| **Set Default View (Project)** | `project -v`                                                                               |
| **Add Client**                 | `client -a n/CLIENT_NAME p/PROJECT_ID [m/CLIENT_MOBILE] [e/CLIENT_EMAIL]`                  |
| **Edit Client**                | `client -e c/CLIENT_ID [n/CLIENT_NAME] [m/CLIENT_MOBILE] [e/CLIENT_EMAIL]`                 |
| **Delete Client**              | `client -d CLIENT_ID`                                                                      |
| **List Clients**               | `client -l`                                                                                |
| **Find Clients**               | `client -f [n/CLIENT_NAME] [m/CLIENT_MOBILE] [e/CLIENT_EMAIL] [c/CLIENT_ID]`               |
| **Pin Clients**                | `client -p CLIENT_ID`                                                                      |
| **Sort Clients**               | `client -s [c/CLIENT_ID] [n/CLIENT_NAME]`                                                  |
| **Set Default View (Client)**  | `client -v`                                                                                |
| **Add Issue**                  | `issue -a p/PROJECT_ID t/TITLE [d/DEADLINE] [u/URGENCY]`                                   |
| **Edit Issue**                 | `issue -e i/ISSUE_ID [t/TITLE] [d/DEADLINE] [u/URGENCY]`                                   |
| **Delete Issue**               | `issue -d ISSUE_ID`                                                                        |
| **List Issues**                | `issue -l`                                                                                 |
| **Find Issues**                | `issue -f [t/TITLE] [n/PROJECT_NAME] [p/PROJECT_ID] [u/URGENCY] [s/STATUS] [i/ISSUE_ID]`   |
| **Pin Issues**                 | `issue -p ISSUE_ID`                                                                        |
| **Sort Issues**                | `issue -s [i/ISSUE_ID] [d/DEADLINE] [u/URGENCY]`                                           |
| **Mark Issue**                 | `issue -m ISSUE_ID`                                                                        |
| **Unmark Issue**               | `issue -u ISSUE_ID`                                                                        |
| **Set Default View (Issue)**   | `issue -v`                                                                                 |
| **Clear**                      | `clear`                                                                                    |
| **Help**                       | `help`                                                                                     |
| **Exit**                       | `exit`                                                                                     |
