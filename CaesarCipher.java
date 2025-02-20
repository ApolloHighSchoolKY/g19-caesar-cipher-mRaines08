/**
 * @(#)CaesarCipher.java
 *
 *
 * @author
 * @version 1.00 2025/2/20
 */


public class CaesarCipher {

	private char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
	private char[] shifted;
	private int shift;

    public CaesarCipher() 
    {
        shift = 1;
        shifted = new char[26];
        shifter(shift);
    }

    public CaesarCipher(int num)
    {
        shift = num;
        shifted = new char[26];
        shifter(shift);
    }

    public String encrypt(String message)
    {
        int pos;
        String code = "";

        //if you dont find it concatinate in on, this requires booleans (it may be a space or a specail character)
        for(int ogL = 0; ogL < message.length(); ogL++)
        {
            pos = -1;

            for(int abcL = 0; abcL < alphabet.length; abcL++)
            {
                if(alphabet[abcL] == message.charAt(ogL))
                    pos = abcL;
            }

            if(pos >= 0)
                code += "" + shifted[pos];
            else
                code += "" + message.charAt(ogL);
        }
        return "" + code;
    }

    public String decrypt(String message)
    {
        String secret = "";
        int pos;

        for(int iMes = 0; iMes < message.length(); iMes++)
        {
            pos = -1;

            for(int iShift = 0; iShift < shifted.length; iShift++)
            {
                if(shifted[iShift] == message.charAt(iMes))
                    pos = iShift;
            }

            if(pos >= 0)
                secret += "" + alphabet[pos];
            else
                secret += "" + message.charAt(iMes);
        }
        
        return "" + secret;
    }

    public void shifter(int num)
    {
        for(int i = num, pos = 0; pos < alphabet.length; i++, pos++)
        {
            i %= 26;
            shifted[i] = alphabet[pos];
        }
    }

    public String toString()
    {
        String output = "";

        for(char l : alphabet)
			output += (" " + l);

		output += "\n";
		for(char l : shifted)
			output += (" " + l);

        return output;
    }


}