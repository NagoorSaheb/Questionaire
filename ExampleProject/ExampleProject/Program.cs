using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Text.RegularExpressions;


namespace ExampleProject
{
    class Repeat
    {
        static void Main(string[] args)
        {
            Console.WriteLine("program 1 to find duplicate");
            program1();
            Console.WriteLine("Second Program to print number format");
            program2();
            Console.ReadLine();
        }

        private static void program2()
        {
            int number;
            String s;
            do
            {
                Console.WriteLine("Please enter a number");
                s = Console.ReadLine();
            } while (!int.TryParse(s, out number));
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < number; i++)
            {
                sb.Append("1");
                Console.WriteLine(sb);
            }
           }

        private static void program1()
        {
            Dictionary<char, int> Pairs = new Dictionary<char, int>();
            String s;
            do
            {
                Console.WriteLine("Please enter a sentence");
                s = Console.ReadLine();

            } while (string.IsNullOrEmpty(s));
            foreach (char ch in s)
            {
                if (Char.IsLetter(ch))
                {  // check for characters only leaving numbers or special characters
                    if (Pairs.ContainsKey(ch))
                        Pairs[ch]++;
                    else
                        Pairs.Add(ch, 1); // single occurrence
                }
            }
            foreach (KeyValuePair<char, int> entry in Pairs)
            {
                if (entry.Value >= 2)
                    Console.WriteLine(entry.Key + " -> " + entry.Value);
            }
           }
    }
}
