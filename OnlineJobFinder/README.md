# Online Job Finder

## Description
You have been asked to develop a system for finding Java developer jobs. In the first version, the functionality of this system is extremely limited: the candidate enters a request and gets the number of suitable vacancies.

The class `JobDescription` represents jobs in this system. It has three fields:

- `title` that is the title of this job (like `"Java Developer"`);
- `company` that is the company offering the job;
- `requiredExperienceYears` that is the work experience (in years) requirement for all applicants;

A request is an object of the `ApplicantRequest` class that contains only two fields:

- `company` that is the name of the company the candidate is interested in;
- `experienceYears` that stores the candidate experience in years (in Java).

To solve this task, you need to implement the `calculateNumberOfVacancies` method in a proper way.

Note that, in the test example, the first line represents the request from an applicant and all the following lines are all available job descriptions in this system.

## Examples
**Sample Input:**
```console
Google|3
Java Developer|Google|3
Senior Java Developer|Google|7
Super Java Developer|CryptoStartup|3
Junior Java Developer|Google|1
```

**Sample Output:**
```console
2
```

## Tags
- data processing with streams
- filtering and skipping elements by conditions