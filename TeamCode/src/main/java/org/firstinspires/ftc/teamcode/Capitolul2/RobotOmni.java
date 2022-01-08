package org.firstinspires.ftc.teamcode.Capitolul2;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class RobotOmni {


    public DcMotor frontLeft = null;
    public DcMotor frontRight = null;
    public DcMotor backLeft = null;
    public DcMotor backRight = null;

    public Servo skystone = null;
    public ColorSensor senzsk = null;
    HardwareMap hwMap;

    public RobotOmni()
    {

    }

    public void init(HardwareMap ahwmap)
    {
        hwMap = ahwmap;
        backLeft = hwMap.get(DcMotor.class, "bl");
        frontLeft = hwMap.get(DcMotor.class, "fl");
        backRight = hwMap.get(DcMotor.class, "br");
        frontRight = hwMap.get(DcMotor.class,"fr");

        skystone = hwMap.get(Servo.class,"skystone");
        senzsk = hwMap.get(ColorSensor.class, "culoare");
        senzsk.enableLed(true);

        frontLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        backLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        backRight.setDirection(DcMotorSimple.Direction.REVERSE);

        backLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        backLeft.setPower(0);
        frontLeft.setPower(0);
        backRight.setPower(0);
        frontRight.setPower(0);

    }
    public void stop() {
        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
    }


    }
