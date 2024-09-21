package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;


/**
 * This OpMode uses the common Pushbot hardware class to define the devices on the robot.
 * All device access is managed through the HardwarePushbot class.
 * The code is structured as a LinearOpMode
 *
 * This particular OpMode executes a POV Game style Teleop for a PushBot
 * In this mode the left stick moves the robot FWD and back, the Right stick turns left and right.
 * It raises and lowers the claw using the Gampad Y and A buttons respectively.
 * It also opens and closes the claws slowly using the left and right Bumper buttons.
 *
 * Use Android Studios to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 */

//hi this is a note

/*
Hi this is another note
 */

@TeleOp(name="Teleop", group="Teleop")
//@Disabled
public class Teleop extends LinearOpMode {
    double left;
    double right;
    double drive;
    double turn;
    double max;
    /* Declare OpMode members. */
    Hardware robot = new Hardware();   // Use our hardware

    @Override
    public void runOpMode() {


        /* Initialize the hardware variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("", "Ready To Go!");    //
        telemetry.update();
        robot.liftRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        robot.liftLeft.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);

        robot.liftRotationRight.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        robot.liftRotationLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            /*In Use:
               Gamepad 1(Drive):
                 -Layer One(No Button)=Drive:
                    Triggers=stafeing
                    Left Stick=Drive
                    Right Stick=Turn
                    Bumper right=layer 3
                    bumper left=layer 2
                -Layer Two(Left Bumper):
                    Bumper left=layer 2
                    bumper right=layer 3
                -layer Three(Right Bumper):
                    Bumper left=layer 2
                    bumper right=layer 3

                Gamepad 2 (controls):
                  -Layer one (no buttons)=Grabber:
                     bumper left=layer 2
                     bumper right-layer 3
                  -layer two (Left Bumper)=Elevator:
                     bumper left=layer 2
                     bumper right-layer 3
                  -layer 3 (Right bumper):
                     bumper left=layer 2
                     bumper right-layer 3
            */
            if(gamepad1.left_bumper){
                robot.grabber.setPower(-1);
            } else if(gamepad1.right_bumper) {
                robot.grabber.setPower(1);
            }else {
                robot.grabber.setPower(0);
            }

            if(gamepad1.left_bumper) {
                if (gamepad1.dpad_up) {
                    robot.liftRight.setPower(0.2);
                } else if (gamepad1.dpad_down) {
                    robot.liftRight.setPower(-0.1);
                } else {
                    robot.liftRight.setPower(0);
                }
            }

            //Strafing and Driving
            if (gamepad1.right_trigger > 0) {
                robot.frontLeft.setPower(gamepad1.right_trigger);   //pos or forwards
                robot.frontRight.setPower(-gamepad1.right_trigger);  //backwards or neg
                robot.rearLeft.setPower(-gamepad1.right_trigger);    //backwards or neg
                robot.rearRight.setPower(gamepad1.right_trigger);   //pos or forwards
            } else if (gamepad1.left_trigger > 0) {
                robot.frontLeft.setPower(-gamepad1.left_trigger);    //backwards or neg
                robot.frontRight.setPower(gamepad1.left_trigger);   //pos or forwards
                robot.rearLeft.setPower(gamepad1.left_trigger);     //pos or forwards
                robot.rearRight.setPower(-gamepad1.left_trigger);    //backwards or neg
            } else {

                // Run wheels in POV mode (note: The joystick goes negative when pushed forwards, so negate it)
                // In this mode the Left stick moves the robot fwd and back, the Right stick turns left and right.
                // This way it's also easy to just drive straight, or just turn.
                drive = -gamepad1.left_stick_y;
                turn = gamepad1.right_stick_x;

                // Combine drive and turn for blended motion.
                left = drive + turn;
                right = drive - turn;

                // Normalize the values so neither exceed +/- 1.0
                max = Math.max(Math.abs(left), Math.abs(right));
                if (max > 1.0) {
                    left /= max;
                    right /= max;
                }

                // Output the safe vales to the motor drives.
                robot.rearLeft.setPower(left);
                robot.rearRight.setPower(right);
                robot.frontLeft.setPower(left);
                robot.frontRight.setPower(right);
                //}

                // Send telemetry message to signify robot running;
                telemetry.addData("left: ", left);
                telemetry.addData("right: ", right);
                telemetry.addData("power", robot.grabber.getPower());
                telemetry.update();
            }

        }
    }
}

