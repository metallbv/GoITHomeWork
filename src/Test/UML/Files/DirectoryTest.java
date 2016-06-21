package Test.UML.Files;

import UML.Files.Directory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by v.babiak on 04.06.2016.
 */
public class DirectoryTest {
    @Test
    public void getName() throws Exception {

    }

    @Test
    public void deleteFile() throws Exception {

    }

    private Directory directory;
    private String illegalString = "*?\"<>|||";

    @Test(timeout = 1000)
    public void checkNameCorrect() throws Exception {

        String checString = "C:\\Windows";
        directory = new Directory(checString);
        ArrayList<Character> result = directory.CheckNameCorrect(checString);
        ArrayList<Character> expected = new ArrayList<>();

        assertArrayEquals(expected.toArray(), result.toArray());

    }


}