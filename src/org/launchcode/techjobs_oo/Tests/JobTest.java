package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;
import static org.junit.Assert.*;

public class JobTest {
    private Job
            job1,
            job2,
            job3;

    @Before
    public void createTestJobObjects() {
        job1 = new Job();
        job2 = new Job();
        job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }

    @Test
    public void testSettingJobId() {
        //Test that the ID values for the two objects are Not the same and differ by 1.
        assertEquals(1, job2.getId() - job1.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        //assertEquals(true,job3 instanceof Job);
        assertEquals("Product tester", job3.getName());
        assertEquals("ACME", job3.getEmployer().getValue());
        assertEquals("Desert", job3.getLocation().getValue());
        assertEquals("Quality control", job3.getPositionType().getValue());
        assertEquals("Persistence", job3.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        assertFalse(job1.equals(job2));
    }
    // Test driven development (TDD) : write tests to satisfy requirements of our future toString method
    // TODO: 1. When passed a Job object, it should return a string that contains a blank line before and after the job information

    @Test
    public void testToStringReturnsNewLine() {
        //Get first character of string
        char firstCharacter = job3.toString().charAt(0);
        //Get last character
        char lastCharacter = job3.toString().charAt(job3.toString().length() - 1);
        assertTrue(firstCharacter == lastCharacter);
    }

    //TODO : 2. The string should contain a label for each field, followed by the data stored in that field.  Each field should be on its own line.
    @Test
    public void testContainsLabelsAndStoredData() {
        String containsLabels = String.format(
                        "\nID: %d\n" +
                        "Name: %s\n" +
                        "Employer: %s\n" +
                        "Location: %s\n" +
                        "Position Type: %s\n" +
                        "Core Competency: %s\n",
                job3.getId(), job3.getName(), job3.getEmployer(), job3.getLocation(), job3.getPositionType(), job3.getCoreCompetency());
        assertEquals(containsLabels, job3.toString());
    }

    //TODO : 3. Write test: If a field is empty, the method should add, "Data not available" after the label.
    @Test
    public void testEmptyFields() {
        job3.getEmployer().setValue("");
        job3.getLocation().setValue("");
        job3.getPositionType().setValue("");
        job3.getCoreCompetency().setValue("");
        String emptyFields = String.format(
                "\nID: %d\n" +
                "Name: %s\n" +
                "Employer: Data not available\n" +
                "Location: Data not available\n" +
                "Position Type: Data not available\n" +
                "Core Competency: Data not available\n",
                job3.getId(),job3.getName());
        assertEquals(emptyFields, job3.toString());
    }

    //TODO : 4.  (BONUS) If a job object ONLY contains data for the id field, the method should return, "OOPS! This job does not seem to exists."
    @Test
    public void testJobDataOnlyContainsDataForIdField() {
        assertEquals("OOPS! This job does not seem to exist.",job1.toString());
    }


}
