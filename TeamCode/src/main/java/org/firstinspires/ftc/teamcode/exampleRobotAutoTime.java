/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * This file illustrates the concept of driving a path based on time.
 * It uses the common Pushbot hardware class to define the drive on the robot.
 * The code is structured as a LinearOpMode
 *
 * The code assumes that you do NOT have encoders on the wheels,
 *   otherwise you would use: PushbotAutoDriveByEncoder;
 *
 *   The desired path in this example is:
 *   - Drive forward for 3 seconds
 *   - Spin right for 1.3 seconds
 *   - Drive Backwards for 1 Second
 *   - Stop and close the claw.
 *
 *  The code is written in a simple form with no optimizations.
 *  However, there are several ways that this type of sequence could be streamlined,
 *
 * Use Android Studios to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 */

@Autonomous(name="Example Auto By Time", group="Pushbot")
//@Disabled
public class exampleRobotAutoTime extends LinearOpMode {

    /* Declare OpMode members. */
    Hardware robot = new Hardware();   // Use a Pushbot's hardware
    private ElapsedTime timer = new ElapsedTime();    //Timer

    double forwardPower = 1;
    double turnPower = 1;

    @Override
    public void runOpMode() {

        /*
         * Initialize the drive system variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Status", "Ready to run");    //
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        driveMacro(1.5);
        turnRightMacro(1);
        driveMacro(1.5);
        turnLeftMacro(1);
        driveSquare();

    }
    public void driveForward() {
        robot.rearRight.setPower(forwardPower);
        robot.rearLeft.setPower(forwardPower);
        robot.frontRight.setPower(forwardPower);
        robot.frontLeft.setPower(forwardPower);
    }
    public void stopRobot(){
        robot.rearRight.setPower(0);
        robot.rearLeft.setPower(0);
        robot.frontRight.setPower(0);
        robot.frontLeft.setPower(0);
    }
    public void turnRobotRight(){
        robot.rearRight.setPower(-turnPower);
        robot.rearLeft.setPower(turnPower);
        robot.frontRight.setPower(-turnPower);
        robot.frontLeft.setPower(turnPower);
    }
    public void turnRobotLeft() {
        robot.rearRight.setPower(turnPower);
        robot.rearLeft.setPower(-turnPower);
        robot.frontRight.setPower(turnPower);
        robot.frontLeft.setPower(-turnPower);
    }
    public void driveMacro(double time){
        timer.reset();
        //Step 1
        driveForward();
        while (timer.seconds() < time){
            telemetry.addData("","Currently moving forward");
            telemetry.update();
        }
        stopRobot();
        sleep(400);
    }
    public void turnRightMacro(double turnRightTime){
        timer.reset();
        turnRobotRight();
        while (timer.seconds() < turnRightTime){
            telemetry.addData("","Currently turning right");
            telemetry.update();
        }
        stopRobot();
        sleep(400);
    }
    public void turnLeftMacro(double turnLeftTime) {
        timer.reset();
        turnRobotLeft();
        while (timer.seconds() < turnLeftTime) {
            telemetry.addData("", "Currently turning right");
            telemetry.update();
        }
        stopRobot();
        sleep(400);
    }
    public void driveSquare(){
        double turntime = 1.5;
        driveMacro(1.3);
        turnLeftMacro(turntime);
        driveMacro(1.3);
        turnLeftMacro(turntime);
        driveMacro(1.3);
        turnLeftMacro(turntime);
        driveMacro(1.3);
        turnLeftMacro(turntime);
    }
}
