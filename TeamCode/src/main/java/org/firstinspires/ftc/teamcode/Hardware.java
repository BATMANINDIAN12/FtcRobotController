package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Hardware {
    public DcMotorEx frontRight =null;
    public DcMotorEx frontLeft =null;
    public DcMotorEx rearRight =null;
    public DcMotorEx rearLeft =null;

    public DcMotorEx liftLeft =null;
    public DcMotorEx liftRight =null;

    public DcMotorEx liftRotationLeft =null;
    public DcMotorEx liftRotationRight =null;
    //servos
    public DcMotorSimple grabber =null;

    public DcMotorSimple wristRotation =null;

    public DcMotorSimple wristAngle =null;

    public DcMotorSimple armRight = null;
    public DcMotorSimple armLeft = null;




    HardwareMap hwMap =null;

    public Hardware(){
    }

    public void init(HardwareMap ahwMap){
        hwMap = ahwMap;
        frontRight = hwMap.get(DcMotorEx.class,"frontRight");
        frontLeft = hwMap.get(DcMotorEx.class,"frontLeft");
        rearRight = hwMap.get(DcMotorEx.class,"rearRight");
        rearLeft = hwMap.get(DcMotorEx.class,"rearLeft");

        liftLeft = hwMap.get(DcMotorEx.class,"liftLeft");
        liftRight = hwMap.get(DcMotorEx.class, "liftRight");

        liftRotationLeft = hwMap.get(DcMotorEx.class, "liftRotationLeft");
        liftRotationRight = hwMap.get(DcMotorEx.class, "lifeRotationRight");

        wristRotation = hwMap.get(DcMotorSimple.class, "wristRotation");
        wristAngle = hwMap.get(DcMotorSimple.class, "wristAngle");

        armLeft = hwMap.get(DcMotorSimple.class, "armLeft");
        armRight = hwMap.get(DcMotorSimple.class, "armRight");

        grabber = hwMap.get(DcMotorSimple.class, "Grabber");


        //setPower
        frontRight.setPower(0);
        frontLeft.setPower(0);
        rearRight.setPower(0);
        rearRight.setPower(0);

        liftLeft.setPower(0);
        liftRight.setPower(0);

        liftRotationRight.setPower(0);
        liftRotationLeft.setPower(0);

        wristRotation.setPower(0);
        wristAngle.setPower(0);

        armLeft.setPower(0);
        armRight.setPower(0);

        grabber.setPower(0);

        //setDirection
        frontRight.setDirection(DcMotorEx.Direction.FORWARD);
        frontLeft.setDirection(DcMotorEx.Direction.REVERSE);
        rearRight.setDirection(DcMotorEx.Direction.FORWARD);
        rearLeft.setDirection(DcMotorEx.Direction.REVERSE);

        liftLeft.setDirection(DcMotorEx.Direction.FORWARD);
        liftRight.setDirection(DcMotorEx.Direction.FORWARD);

        liftRotationLeft.setDirection(DcMotorEx.Direction.FORWARD);
        liftRotationRight.setDirection(DcMotorEx.Direction.REVERSE);

        wristRotation.setDirection(DcMotorSimple.Direction.FORWARD);
        wristAngle.setDirection(DcMotorSimple.Direction.FORWARD);

        grabber.setDirection(DcMotorSimple.Direction.FORWARD);


        //encoderVsNoEncoder
        frontRight.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        frontLeft.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        rearLeft.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        rearRight.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);

        liftLeft.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
        liftRight.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);

        liftRotationRight.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
        liftRotationLeft.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);

        


        liftRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
}