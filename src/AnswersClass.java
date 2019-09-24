
public class AnswersClass {

	public AnswersClass() {
	}
	
	public static double[] getAnswerForInt(int d){
		switch(d)
		{
		case 0:
			double[] answer0 = {1,0,0,0,0,0,0,0,0,0};
			return answer0;
		case 1:
			double[] answer1 = {0,1,0,0,0,0,0,0,0,0};
			return answer1;
		case 2:
			double[] answer2 = {0,0,1,0,0,0,0,0,0,0};
			return answer2;
		case 3:
			double[] answer3 = {0,0,0,1,0,0,0,0,0,0};
			return answer3;
		case 4:
			double[] answer4 = {0,0,0,0,1,0,0,0,0,0};
			return answer4;
		case 5:
			double[] answer5 = {0,0,0,0,0,1,0,0,0,0};
			return answer5;
		case 6:
			double[] answer6 = {0,0,0,0,0,0,1,0,0,0};
			return answer6;
		case 7:
			double[] answer7 = {0,0,0,0,0,0,0,1,0,0};
			return answer7;
		case 8:
			double[] answer8 = {0,0,0,0,0,0,0,0,1,0};
			return answer8;
		case 9:
			double[] answer9 = {0,0,0,0,0,0,0,0,0,1};
			return answer9;
		}
		return null;
		
		
	}
	

}
