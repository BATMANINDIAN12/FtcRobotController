package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Hardware {
    public DcMotorEx frontRight = null;
    public DcMotorEx frontLeft = null;
    public DcMotorEx rearRight = null;
    public DcMotorEx rearLeft = null;

    public DcMotorEx liftLeft = null;
    public DcMotorEx liftRight = null;

    public DcMotorEx liftRotationLeft = null;
    public DcMotorEx liftRotationRight = null;

    // Servos
    public Servo grabber = null;
    public Servo wristRotation = null;
    public Servo wristAngle = null;
    public Servo armRight = null;
    public Servo armLeft = null;

    HardwareMap hwMap = null;

    public Hardware() {
    }

    public void init(HardwareMap ahwMap) {
        hwMap = ahwMap;
        frontRight = hwMap.get(DcMotorEx.class, "frontRight");
        frontLeft = hwMap.get(DcMotorEx.class, "frontLeft");
        rearRight = hwMap.get(DcMotorEx.class, "rearRight");
        rearLeft = hwMap.get(DcMotorEx.class, "rearLeft");

        liftLeft = hwMap.get(DcMotorEx.class, "liftLeft");
        liftRight = hwMap.get(DcMotorEx.class, "liftRight");

        liftRotationLeft = hwMap.get(DcMotorEx.class, "liftRotationLeft");
        liftRotationRight = hwMap.get(DcMotorEx.class, "liftRotationRight");

        grabber = hwMap.get(Servo.class, "grabber");
        wristRotation = hwMap.get(Servo.class, "wristRotation");
        wristAngle = hwMap.get(Servo.class, "wristAngle");
        armLeft = hwMap.get(Servo.class, "armLeft");
        armRight = hwMap.get(Servo.class, "armRight");

        // Set initial positions for servos
        grabber.setPosition(0);
        wristRotation.setPosition(0);
        wristAngle.setPosition(0);
        armLeft.setPosition(0);
        armRight.setPosition(0);

        // Set power for motors
        frontRight.setPower(0);
        frontLeft.setPower(0);
        rearRight.setPower(0);
        rearLeft.setPower(0);

        liftLeft.setPower(0);
        liftRight.setPower(0);

        liftRotationRight.setPower(0);
        liftRotationLeft.setPower(0);

        // Set direction for motors
        frontRight.setDirection(DcMotorEx.Direction.FORWARD);
        frontLeft.setDirection(DcMotorEx.Direction.REVERSE);
        rearRight.setDirection(DcMotorEx.Direction.FORWARD);
        rearLeft.setDirection(DcMotorEx.Direction.REVERSE);

        liftLeft.setDirection(DcMotorEx.Direction.FORWARD);
        liftRight.setDirection(DcMotorEx.Direction.FORWARD);

        liftRotationLeft.setDirection(DcMotorEx.Direction.FORWARD);
        liftRotationRight.setDirection(DcMotorEx.Direction.REVERSE);

        // Set encoder modes for motors
        frontRight.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        frontLeft.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        rearLeft.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        rearRight.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);

        liftLeft.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
        liftRight.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);

        liftRotationRight.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
        liftRotationLeft.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);

        liftRight.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        liftLeft.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);

        liftRotationRight.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        liftRotationLeft.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
    }
}
