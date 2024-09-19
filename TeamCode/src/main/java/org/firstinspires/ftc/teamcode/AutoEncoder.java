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

@Autonomous(name="Auto By Encoder", group="Pushbot")
//@Disabled
public class AutoEncoder extends LinearOpMode {

    /* Declare OpMode members. */
    Hardware robot = new Hardware();   // Use a Pushbot's hardware
    private ElapsedTime timer = new ElapsedTime();    //Timer

    double forwardPower = 1;
    double turnPower = 1;
    int ticksperinch= 116;
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

        stopRobot();

        targetPositionForward(12);
        drivePowerLevel(forwardPower);
        runTo();
        while (robot.frontRight.isBusy()) {
            telemetry.addData("Strafing Right", "");
            telemetry.update();
        }
        stopRobot();
        stopReset();

        targetPositionTurnRight(2000);
        drivePowerLevel(forwardPower);
        runTo();
        while (robot.frontRight.isBusy()) {
            telemetry.addData("Strafing Right", "");
            telemetry.update();
        }
        stopRobot();
        stopReset();

        quarterFirstHalf();  //First quarter

        stopRobot();
        stopReset();

        quarterFirstHalf();  //Second quarter

        stopRobot();
        stopReset();

        quarterFirstHalf();  //Third quarter

        stopRobot();
        stopReset();

        grabCube();

        stopRobot();
        stopReset();

        targetPositionForward(20);
        drivePowerLevel(forwardPower);
        runTo();
        while (robot.frontRight.isBusy()) {
            telemetry.addData("Strafing Right", "");
            telemetry.update();
        }
        stopRobot();
        stopReset();

        targetPositionTurnLeft(2000);
        drivePowerLevel(forwardPower);
        runTo();
        while (robot.frontRight.isBusy()) {
            telemetry.addData("Strafing Right", "");
            telemetry.update();
        }
        stopRobot();
        stopReset();

        targetPositionForward(20);
        drivePowerLevel(forwardPower);
        runTo();
        while (robot.frontRight.isBusy()) {
            telemetry.addData("Strafing Right", "");
            telemetry.update();
        }
        stopRobot();
        stopReset();

        dropCube();

        stopRobot();
        stopReset();

        grabCube();

        stopRobot();
        stopReset();

        targetPositionBack(20);
        drivePowerLevel(forwardPower);
        runTo();
        while (robot.frontRight.isBusy()) {
            telemetry.addData("Strafing Right", "");
            telemetry.update();
        }

        stopRobot();
        stopReset();

        targetPositionTurnRight(2000);
        drivePowerLevel(forwardPower);
        runTo();
        while (robot.frontRight.isBusy()) {
            telemetry.addData("Strafing Right", "");
            telemetry.update();
        }

        stopRobot();
        stopReset();

        targetPositionBack(20);
        drivePowerLevel(forwardPower);
        runTo();
        while (robot.frontRight.isBusy()) {
            telemetry.addData("Strafing Right", "");
            telemetry.update();
        }

        stopRobot();
        stopReset();

        quarterSecondHalf();    //First quarter

        stopRobot();
        stopReset();

        quarterSecondHalf();    //Second quarter

        stopRobot();
        stopReset();

        quarterSecondHalf();    //Third quarter

        stopRobot();
        stopReset();

        targetPositionBack(10);
        drivePowerLevel(forwardPower);
        runTo();
        while (robot.frontRight.isBusy()) {
            telemetry.addData("Strafing Right", "");
            telemetry.update();
        }
        stopRobot();
        stopReset();

        targetPositionTurnRight(2000);
        drivePowerLevel(forwardPower);
        runTo();
        while (robot.frontRight.isBusy()) {
            telemetry.addData("Strafing Right", "");
            telemetry.update();
        }
        stopRobot();
        stopReset();

        targetPositionBack(12);
        drivePowerLevel(forwardPower);
        runTo();
        while (robot.frontRight.isBusy()) {
            telemetry.addData("Strafing Right", "");
            telemetry.update();
        }
        stopRobot();
        stopReset();

    }
    public void quarterSecondHalf(){
        dropCube();

        stopRobot();
        stopReset();

        targetPositionBack(40);
        drivePowerLevel(forwardPower);
        runTo();
        while (robot.frontRight.isBusy()) {
            telemetry.addData("Strafing Right", "");
            telemetry.update();
        }
        stopRobot();
        stopReset();

        targetPositionTurnRight(2000);
        drivePowerLevel(forwardPower);
        runTo();
        while (robot.frontRight.isBusy()) {
            telemetry.addData("Strafing Right", "");
            telemetry.update();
        }
        stopRobot();
        stopReset();

        targetPositionBack(20);
        drivePowerLevel(forwardPower);
        runTo();
        while (robot.frontRight.isBusy()) {
            telemetry.addData("Strafing Right", "");
            telemetry.update();
        }

        stopRobot();
        stopReset();

        targetPositionTurnRight(2000);
        drivePowerLevel(forwardPower);
        runTo();
        while (robot.frontRight.isBusy()) {
            telemetry.addData("Strafing Right", "");
            telemetry.update();
        }

        stopRobot();
        stopReset();

        grabCube();

        stopRobot();
        stopReset();

        targetPositionBack(20);
        drivePowerLevel(forwardPower);
        runTo();
        while (robot.frontRight.isBusy()) {
            telemetry.addData("Strafing Right", "");
            telemetry.update();
        }
        stopRobot();
        stopReset();

        targetPositionTurnRight(2000);
        drivePowerLevel(forwardPower);
        runTo();
        while (robot.frontRight.isBusy()) {
            telemetry.addData("Strafing Right", "");
            telemetry.update();
        }
        stopRobot();
        stopReset();

        targetPositionBack(20);
        drivePowerLevel(forwardPower);
        runTo();
        while (robot.frontRight.isBusy()) {
            telemetry.addData("Strafing Right", "");
            telemetry.update();
        }
        stopRobot();
        stopReset();

    }
    public void quarterFirstHalf(){
        grabCube();

        stopRobot();
        stopReset();

        targetPositionForward(20);
        drivePowerLevel(forwardPower);
        runTo();
        while (robot.frontRight.isBusy()) {
            telemetry.addData("Strafing Right", "");
            telemetry.update();
        }
        stopRobot();
        stopReset();

        targetPositionTurnLeft(2000);
        drivePowerLevel(forwardPower);
        runTo();
        while (robot.frontRight.isBusy()) {
            telemetry.addData("Strafing Right", "");
            telemetry.update();
        }
        stopRobot();
        stopReset();

        targetPositionForward(20);
        drivePowerLevel(forwardPower);
        runTo();
        while (robot.frontRight.isBusy()) {
            telemetry.addData("Strafing Right", "");
            telemetry.update();
        }
        stopRobot();
        stopReset();

        dropCube();

        stopRobot();
        stopReset();

        targetPositionTurnLeft(2000);
        drivePowerLevel(forwardPower);
        runTo();
        while (robot.frontRight.isBusy()) {
            telemetry.addData("Strafing Right", "");
            telemetry.update();
        }
        stopRobot();
        stopReset();

        targetPositionForward(20);
        drivePowerLevel(forwardPower);
        runTo();
        while (robot.frontRight.isBusy()) {
            telemetry.addData("Strafing Right", "");
            telemetry.update();
        }
        stopRobot();
        stopReset();

        targetPositionTurnLeft(2000);
        drivePowerLevel(forwardPower);
        runTo();
        while (robot.frontRight.isBusy()) {
            telemetry.addData("Strafing Right", "");
            telemetry.update();
        }
        stopRobot();
        stopReset();

        targetPositionForward(40);
        drivePowerLevel(forwardPower);
        runTo();
        while (robot.frontRight.isBusy()) {
            telemetry.addData("Strafing Right", "");
            telemetry.update();
        }
        stopRobot();
        stopReset();
    }
    public void dropCube(){
        while(timer.seconds()<3){
            robot.liftRight.setPower(-0.5);
        }
        timer.reset();
        while(timer.seconds()<2){
            robot.grabber.setPower(-1);
        }
        timer.reset();
        while(timer.seconds()<1){
            robot.liftRight.setPower(0.2);
        }
        timer.reset();
        while(timer.seconds()<2){
            robot.grabber.setPower(1);
        }
        timer.reset();
        robot.liftRight.setPower(0.0);


    }
    public void grabCube(){
        while(timer.seconds()<2){
            robot.grabber.setPower(-1);
        }
        timer.reset();
        while(timer.seconds()<3){
            robot.liftRight.setPower(-0.5);
        }
        timer.reset();
        targetPositionForward(5);
        drivePowerLevel(forwardPower);
        runTo();
        while (robot.frontRight.isBusy()) {
            telemetry.addData("Strafing Right", "");
            telemetry.update();
        }
        stopRobot();
        stopReset();

        timer.reset();
        while(timer.seconds()<2){
            robot.grabber.setPower(1);
        }
        timer.reset();
        while(timer.seconds()<1){
            robot.liftRight.setPower(0.2);
        }
        timer.reset();
        robot.liftRight.setPower(0.0);
    }
    public void dropCube(double beltTime){
        robot.liftLeft.setPower(1);
        timer.reset();
        while(timer.seconds()<beltTime){
            telemetry.addData("motor running for intake","");
            telemetry.update();
        }
        robot.liftLeft.setPower(0);
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
    public void targetPositionForward(int inchTarget){
        robot.frontRight.setTargetPosition(inchTarget * ticksperinch);
        robot.frontLeft.setTargetPosition(inchTarget* ticksperinch);
        robot.rearLeft.setTargetPosition(inchTarget* ticksperinch);
        robot.rearRight.setTargetPosition(inchTarget* ticksperinch);
    }
    public void targetPositionBack(int inchTarget){
        robot.frontRight.setTargetPosition(-inchTarget* ticksperinch);
        robot.frontLeft.setTargetPosition(-inchTarget* ticksperinch);
        robot.rearLeft.setTargetPosition(-inchTarget* ticksperinch);
        robot.rearRight.setTargetPosition(-inchTarget* ticksperinch);
    }
    public void targetPositionTurnLeft(int tickTurnTarget){
        robot.frontRight.setTargetPosition(tickTurnTarget);
        robot.frontLeft.setTargetPosition(-tickTurnTarget);
        robot.rearLeft.setTargetPosition(-tickTurnTarget);
        robot.rearRight.setTargetPosition(tickTurnTarget);
    }
    public void targetPositionTurnRight(int tickTurnTarget){
        robot.frontRight.setTargetPosition(-tickTurnTarget);
        robot.frontLeft.setTargetPosition(tickTurnTarget);
        robot.rearLeft.setTargetPosition(tickTurnTarget);
        robot.rearRight.setTargetPosition(-tickTurnTarget);
    }
    public void targetPositionStrafeRight(int inchTarget){
        robot.frontRight.setTargetPosition(-inchTarget* ticksperinch);
        robot.frontLeft.setTargetPosition(inchTarget* ticksperinch);
        robot.rearLeft.setTargetPosition(-inchTarget* ticksperinch);
        robot.rearRight.setTargetPosition(inchTarget* ticksperinch);
    }
    public void targetPositionStrafeLeft(int inchTarget){
        robot.frontRight.setTargetPosition(inchTarget* ticksperinch);
        robot.frontLeft.setTargetPosition(-inchTarget* ticksperinch);
        robot.rearLeft.setTargetPosition(inchTarget* ticksperinch);
        robot.rearRight.setTargetPosition(-inchTarget* ticksperinch);
    }
    public void runTo(){
        robot.frontRight.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        robot.frontLeft.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        robot.rearRight.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        robot.rearLeft.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
    }
}
//comment
