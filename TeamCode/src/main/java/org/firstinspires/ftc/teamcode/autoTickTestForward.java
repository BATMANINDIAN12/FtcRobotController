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
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="Forward Tick Test", group="Pushbot")
//@Disabled
public class autoTickTestForward extends LinearOpMode {

    /* Declare OpMode members. */
    Hardware robot = new Hardware();   // Use a Pushbot's hardware
    private ElapsedTime timer = new ElapsedTime();    //Timer

    double forwardPower = 1;

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

        robot.frontRight.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        robot.frontLeft.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        robot.rearLeft.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        robot.rearRight.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        stopReset();
        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        targetPositionForward(5000);
        drivePowerLevel(1);
        runTo();
        while (robot.frontRight.isBusy()){
            telemetry.addData("moving", "");
            telemetry.update();

        }
        stopRobot();
        stopReset();
        sleep(1000);
        stop();
    }

    public void drivePowerLevel(double power) {
        robot.rearRight.setPower(power);
        robot.rearLeft.setPower(power);
        robot.frontRight.setPower(power);
        robot.frontLeft.setPower(power);
    }
    public void stopRobot(){
        robot.rearRight.setPower(0);
        robot.rearLeft.setPower(0);
        robot.frontRight.setPower(0);
        robot.frontLeft.setPower(0);
    }
    public void stopReset(){
        robot.frontRight.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        robot.frontLeft.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        robot.rearRight.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        robot.rearLeft.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
    }
    public void targetPositionForward(int tickTarget){
        robot.frontRight.setTargetPosition(tickTarget);
        robot.frontLeft.setTargetPosition(tickTarget);
        robot.rearLeft.setTargetPosition(tickTarget);
        robot.rearRight.setTargetPosition(tickTarget);
    }

    public void runTo(){
        robot.frontRight.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        robot.frontLeft.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        robot.rearRight.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        robot.rearLeft.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
    }
}
//comment
