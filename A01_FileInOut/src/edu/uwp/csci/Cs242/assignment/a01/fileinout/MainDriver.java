package edu.uwp.csci.Cs242.assignment.a01.fileinout;
import java.io.PrintWriter;
import java.util.Scanner;
public class MainDriver
{
    public static void main ( String[] args )
    {
        FileInOut fio = new FileInOut ( "infile.txt", "outfile.txt", true );
        Scanner in = fio.getInFile();
        PrintWriter out = fio.getOutFile();
        System.out.println ( "Starting MainDriver()." );
        while ( in.hasNext() )
        {
            String word = in.next();
            out.print ( word );
        }
        fio.closeFiles();
        System.out.println ( "Ending MainDriver()." );
    }
}
