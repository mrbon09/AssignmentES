package com.assignment.duy.assignmentes;

import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ListView;
import android.os.Bundle;

import org.w3c.dom.Text;

import java.util.Scanner;

public class HealthyAdvice extends Fragment {
    //public static void main(String args[]) {
        /*Scanner sc = new Scanner(System.in);
        System.out.print("Input weight in kilogram: ");
        double weight = sc.nextDouble();
        System.out.print("\nInput height in meters: ");
        double height = sc.nextDouble();*/
        Button ButtonBMI;
        TextView mTextView;
       // Button btn;
        TextView txt;
        //@Override
//        public void onCreate(Bundle savedInstanceState){
////            super.onCreate(savedInstanceState);
////            setContentView(R.layout.activity_main);
////            txt=(TextView) findViewById(R.id.mytext);
////            btn=(Button) findViewById(R.id.mybutton);
////            bỏ cái này đi
////            btn.setOnClickListener(new View.OnClickListener(){
////                @Override
////                public void OnClick(View v){
////                    txt.setText("hello mother fucker");
////                }
////            });
////        } chay thu xem
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.advice_layout, container, false);
            super.onCreate (savedInstanceState);
            final EditText height = view.findViewById(R.id.height); // lấy data mytext chưa khai báo thì phải
            final EditText weight = view.findViewById(R.id.weight);
             txt=(TextView) view.findViewById(R.id.txt);
            ButtonBMI = (Button)view.findViewById(R.id.BMIButton);
            ButtonBMI.setOnClickListener(new View.OnClickListener()
            {

                public void onClick(View view) {
                    CalculateBMIResult(height.getText().toString(),weight.getText().toString(),txt);
                }
            });
            return view;
            }


        public void CalculateBMIResult(String height,String weight, TextView txt )// height vs weight xài dc do dc khai báo ở đây nè
            {
                double heightd = Double.parseDouble(height);
                double weightd = Double.parseDouble(weight);
                double BMI = weightd / (heightd * heightd);
            if (BMI < 18.5) {
                txt.setText("\n\n\n\n\nThe Body Mass Index (BMI) is " + BMI + " kg/m2\n" +
                        "You are Underweight: being underweight is defined as having a body mass index (BMI) below 18.5. This is estimated to be less than the body mass needed to sustain optimal health.\n" +
                        "Several Things Can Cause Someone to Become Underweight:\n" +
                        "1.•\tEating disorders: This includes anorexia nervosa, a serious mental disorder.\n" +
                        "2.•\tThyroid problems: Having an overactive thyroid (hyperthyroidism) can boost metabolism and cause unhealthy weight loss.\n" +
                        "3.•\tCeliac disease: The most severe form of gluten intolerance. Most people with celiac disease don't know that they have it (10 Trusted Source).\n" +
                        "4.•\tDiabetes: Having uncontrolled diabetes (mainly type 1) can lead to severe weight loss.\n" +
                        "5.•\tCancer: Cancerous tumors often burn large amounts of calories and can cause someone to lose a lot of weight.\n" +
                        "6.•\tInfections: Certain infections can cause someone to become severely underweight. This includes parasites, tuberculosis and HIV/AIDS.\n" +
                        "How to gain weight in healthy way\n:" +
                        "Eat More Calories Than Your Body Burns\n" +
                        "Eat Plenty of Protein\n" +
                        "Fill up on Plenty of Carbs and Fat and Eat at Least 3 Times per Day\n" +
                        "Eat Energy-Dense Foods and Use Sauces, Spices and Condiments\n" +
                        "some energy-dense foods that are perfect for gaining weight:\n" +
                        "\n" +
                        "Nuts: Almonds, walnuts, macadamia nuts, peanuts, etc.\n" +
                        "Dried fruit: Raisins, dates, prunes and others.\n" +
                        "High-fat dairy: Whole milk, full-fat yogurt, cheese, cream.\n" +
                        "Fats and oils: Extra virgin olive oil and avocado oil.\n" +
                        "Grains: Whole grains like oats and brown rice.\n" +
                        "Meat: Chicken, beef, pork, lamb, etc. Choose fattier cuts.\n" +
                        "Tubers: Potatoes, sweet potatoes and yams.\n" +
                        "Dark chocolate, avocados, peanut butter, coconut milk, granola, trail mixes.\n" +
                        "Here are 10 more tips to gain weight:\n" +
                        "\n" +
                        "1.Don't drink water before meals. This can fill your stomach and make it harder to get in enough calories.\n" +
                        "2.Eat more often. Squeeze in an additional meal or snack whenever you can, such as before bed.\n" +
                        "3.Drink milk. Drinking whole milk to quench thirst is a simple way to get in more high-quality protein and calories.\n" +
                        "4.Try weight gainer shakes. If you’re really struggling then you can try weight gainer shakes. These are very high in protein, carbs and calories.\n" +
                        "5.Use bigger plates. Definitely use large plates if you’re trying to get in more calories, as smaller plates cause people to automatically eat less.\n" +
                        "6.Add cream to your coffee. This is a simple way to add in more calories.\n" +
                        "7.Take creatine. The muscle building supplement creatine monohydrate can help you gain a few pounds in muscle weight.\n" +
                        "8.Get quality sleep. Sleeping properly is very important for muscle growth.\n" +
                        "9.Eat your protein first and vegetables last. If you have a mix of foods on your plate, eat the calorie-dense and protein-rich foods first. Eat the vegetables last.\n" +
                        "10.Don't smoke. Smokers tend to weigh less than non-smokers, and quitting smoking often leads to weight gain." +
                        "more information about diets and exercises below: \n" +
                        "https://www.mayoclinic.org/healthy-lifestyle/nutrition-and-healthy-eating/expert-answers/underweight/faq-20058429 \n" +
                        "https://www.medicalnewstoday.com/articles/321518.php\n" +
                        "https://familydoctor.org/healthy-ways-to-gain-weight-if-youre-underweight/\n");

            }
            if ((BMI >= 18.5) && (BMI <= 24.9)) {
                txt.setText("\n\n\n\n\nThe Body Mass Index (BMI) is " + BMI + " kg/m2\n" +
                        "Congratulations, you have an ideal BMI that healthy person needs, let's keep your fitness:\n" +
                        "Eating a well-balanced diet can help you get the calories and nutrients you need to fuel your daily activities, including regular exercise.\n" +
                        "1.Count on the right carbohydrates\n" +
                        "2.Pack protein into your snacks and meals\n" +
                        "Protein can come from:\n" +
                        "\n" +
                        "poultry, such as chicken and turkey\n" +
                        "red meat, such as beef and lamb\n" +
                        "fish, such as salmon and tuna\n" +
                        "dairy, such as milk and yogurt\n" +
                        "legumes, such as beans and lentils\n" +
                        "eggs\n" +
                        "3.Boost your fruit and vegetable intake\n" +
                        "4.Choose healthy fats\n" +
                        " Healthy options include:\n" +
                        "\n" +
                        "nuts\n" +
                        "seeds\n" +
                        "avocados\n" +
                        "olives\n" +
                        "oils, such as olive oil\n" +
                        "5.Fuel up before exercise\n" +
                        "6.Nut butter\n" +
                        "an apple\n" +
                        "a banana\n" +
                        "whole-grain crackers\n" +
                        "a slice of whole-grain bread\n" +
                        "7.Don’t cut too many calories\n" +
                        "If you’re trying to lose weight or tone your body, you may be tempted to cut a ton of calories from your meals. Cutting calories is a key part of weight loss, but it’s possible to go too far.\n" +
                        "\n" +
                        "Weight loss diets should never leave you feeling exhausted or ill. Those are signs that you’re not getting the calories you need for good health and fitness." +

                        "more information about diets and exercises below:\n" +
                        "https://www.health.com/weight-loss/30-simple-diet-and-fitness-tips\n" +
                        "https://www.healthline.com/nutrition/14-ways-to-stick-to-a-diet#section7\n" +
                        "https://www.healthline.com/nutrition/11-ways-to-lose-weight-without-diet-or-exercise\n");

            }
            if ((BMI >= 25) && (BMI <= 29.9)) {
                txt.setText("\n\n\n\n\nThe Body Mass Index (BMI) is " + BMI + " kg/m2\n" +
                        "You are overweight:eating excess calories leads to weight gain\n" +
                        "Healthy Diet Tips for Overweight People:\n" +
                        "1: Ensure a Sufficient Intake of B Vitamins\n" +
                        "2: Be Sure to Get Enough Vitamin D to Reduce Fat Accumulation in Winter\n" +
                        "3: Consume Catechins to Boost Fat Burning\n" +
                        "4:  Eat Plenty of Foods Rich in Vitamin C\n" +
                        "5: Get Enough Calcium to Regulate Body Composition\n" +
                        "6:  Consume Iodine-Rich Foods to Prevent Sluggish Thyroid Activity\n" +
                        "7: Eat Foods Rich in Zinc to Regulate Fat Storage and Appetite\n" +
                        "8:  Cut Down on Calories, Especially in the Evening\n" +
                        "9:  Limit Your Alcohol Consumption\n" +
                        "10:  Watch Out for Fats but Don't Eliminate the Good Fats Completely\n" +
                        "11:  Drink Plenty of Water\n" +
                        "12:  Go for Low-GI Carbs\n" +
                        "13:  Increase Your Fiber Intake\n" +
                        "14:  Burn Calories with Capsaicin\n" +
                        "15: Usually take exercise at least 1 time per day\n" +

                        "more information about diets and exercises below:\n" +
                        "https://www.rd.com/health/fitness/exercise-for-overweight/\n" +
                        "https://rw.yourketo.diet/?gclid=EAIaIQobChMIx72nps2c4gIVxZWPCh0UOgFwEAAYASAAEgIOfvD_BwE\n" +
                        "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC3738392/\n");
            }
            if ((BMI >= 30) && (BMI <= 40)) {
                txt.setText("\n\n\n\n\nThe Body Mass Index (BMI) is " + BMI + " kg/m2\n" +
                        "Warning, you are now obese:abnormal or excessive fat accumulation that presents a risk to health.\n " +
                        "Here are some tips for you to follow with doctor's treatment:\n" +
                        "Group A\" is made up of those obese people who are able to perform normal \"lifting\" style exercises and light to moderate cardio with very little to no pain in their bones. (Muscle pain and soreness is always acceptable). My program for this group is made up of some light lifting to introduce them to working out with weights slowly.\n" +
                        "\"Group B\" is made up of those obese people who are not able to perform normal \"lifting\" style exercises without additional pain coming from their joints and bones, but are able to do some light cardio. This workout program is made up of light cardio performed throughout the week.\n" +
                        "Finally, \"Group C\" is made up of individuals who have problems moving around for long periods of time. Yes, even these people are able to get a workout, burn calories, and work muscles.\n" +
                        "Group A\n" +
                        "Day 1:\n" +
                        "\n" +
                        "Dumbbell Bench Press\n" +
                        "Incline Bench Press\n" +
                        "Cable Crossovers\n" +
                        "One Arm Dumbbell Rows\n" +
                        "V-bar pulldowns\n" +
                        "Deadlifts\n" +
                        "Day 2:\n" +
                        "\n" +
                        "Dumbbell Lateral Raises\n" +
                        "Arnold Dumbbell Presses\n" +
                        "Cambered Bar Curls\n" +
                        "Seated Dumbbell Curls\n" +
                        "Seated Triceps Press\n" +
                        "Triceps Pushdown\n" +
                        "Wrist Curls\n" +
                        "Day 3:\n" +
                        "\n" +
                        "Leg Press \n" +
                        "Leg Extensions\n" +
                        "Hamstring Curls\n" +
                        "Seated Calf Raises\n" +
                        "Standing Calf Raises\n" +
                        "*This program also includes light cardio performed on 3 off days for 45 minutes per day. There should be at least one day's rest between each lifting day.\n" +
                        "Group B Workout\n" +
                        "5-6 days of cardio performed at least twice a day that adds up to 60 minutes per day. Also crunches performed 3 times per week doing 3 sets to failure.\n" +
                        "\n" +
                        "Cardio Activities Include:\n" +
                        "\n" +
                        "Walking\n" +
                        "Jogging\n" +
                        "Biking\n" +
                        "Rowing\n" +
                        "Swimming\n" +
                        "Aerobics class\n" +
                        "Jumping Rope\n" +
                        "Anything else you can think of to keep you moving.\n" +
                        "Group C Workout\n" +
                        "Since this group is unable to perform any activities used by the other groups, we need to just get them moving, period. I know it sounds silly, especially to us iron freaks, but there's a show on public television that has an old lady doing a workout show while sitting in a chair.\n" +
                        "\n" +
                        "They perform these exercises either with no weight, or light weights found around the house (for example, soup cans). Now I laughed when I first heard of this, but I have seen some elderly obese people use this to move towards their goal of being able to perform normal activities. So for Group C, I would advise watching/taping the show and performing these workouts.\n" +
                        "Some healthy complex carbs:\n" +
                        "\n" +
                        "Whole wheat bread\n" +
                        "Oatmeal\n" +
                        "Whole wheat pasta\n" +
                        "Brown rice\n" +
                        "Potatoes\n" +
                        "Some healthy protein supplies:\n" +
                        "\n" +
                        "Lean cuts of beef\n" +
                        "Fish\n" +
                        "Eggs (but don't eat too many yolks)\n" +
                        "Fat free cottage cheese\n" +
                        "Perhaps a little protein powder\n" +
                        "Skim milk\n" +
                        "Fat free yogurt\n" +
                        "Turkey\n" +
                        "Chicken\n" +
                        "Fat free peanut butter\n" +
                        "Any fruits or vegetables you can get your hands on\n" +
                        "Crisp, refreshing spring water\n" +
                        "A good multivitamin\n" +
                        "Now we're on our way! So for each one of our meals, we want to have a nice balanced plate of one or two servings of each one of these groups. Now after a few days of this, you'll wonder how you ever lived any other way." +
                        "Some of the foods you should order are:\n" +
                        "\n" +
                        "Chicken\n" +
                        "Eggs\n" +
                        "Fruits\n" +
                        "Oatmeal\n" +
                        "Wheat\n" +
                        "Multi grained bread\n" +
                        "Spanish rice\n" +
                        "Brown rice\n" +
                        "Vegetables\n" +
                        "Olive oil\n" +
                        "Calamari\n" +
                        "Tuna\n" +
                        "Ham\n" +
                        "And many other choices.\n" +
                        "Foods you should ignore are:\n" +
                        "\n" +
                        "Most Chinese foods\n" +
                        "Steaks\n" +
                        "Butter\n" +
                        "Hamburgers\n" +
                        "Cheeseburgers\n" +
                        "Ice cream\n" +
                        "Pasta\n" +
                        "And anything oily, sugary, fried, or saucy.\n" +
                        "Importantly, you should visit doctor for professional treatment, good luck for your health\n");
            }
            }}

