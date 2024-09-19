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
        liftRight = hwMap.get(DcMotorEx.class, "Grabber Lift");
        grabber = hwMap.get(DcMotorSimple.class, "Grabber");

        frontRight.setPower(0);
        frontLeft.setPower(0);
        rearRight.setPower(0);
        rearRight.setPower(0);
        liftLeft.setPower(0);
        liftRight.setPower(0);
        grabber.setPower(0);

        frontRight.setDirection(DcMotorEx.Direction.FORWARD);
        frontLeft.setDirection(DcMotorEx.Direction.REVERSE);
        rearRight.setDirection(DcMotorEx.Direction.FORWARD);
        rearLeft.setDirection(DcMotorEx.Direction.REVERSE);
        liftLeft.setDirection(DcMotor.Direction.FORWARD);

        frontRight.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        frontLeft.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        rearLeft.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        rearRight.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        liftLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        liftRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
}