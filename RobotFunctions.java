package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class RobotFunctions {

    DcMotor leftIntakeMotor, rightIntakeMotor, leftOuttakeMotor, rightOuttakeMotor;

    Servo launchServo;


    public void init(HardwareMap hwMap){

        this.leftIntakeMotor = hwMap.get(DcMotor.class, "leftIntakeMotor");
        this.rightIntakeMotor = hwMap.get(DcMotor.class, "rightIntakeMotor");

        this.leftOuttakeMotor = hwMap.get(DcMotor.class, "leftOuttakeMotor");
        this.rightOuttakeMotor = hwMap.get(DcMotor.class, "rightOuttakeMotor");

        this.launchServo = hwMap.get(Servo.class, "launchServo");

        this.leftIntakeMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        this.rightIntakeMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        this.leftOuttakeMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        this.rightOuttakeMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        this.leftIntakeMotor.setDirection(DcMotor.Direction.FORWARD);
        this.rightIntakeMotor.setDirection(DcMotor.Direction.REVERSE);

        this.leftOuttakeMotor.setDirection(DcMotor.Direction.FORWARD);
        this.rightOuttakeMotor.setDirection(DcMotor.Direction.REVERSE);

    }

    public void activateIntake(double power, boolean isHeld) {

        if (isHeld) {
            this.leftIntakeMotor.setPower(power);
            this.rightIntakeMotor.setPower(power);
        } else {
            this.leftIntakeMotor.setPower(0.0);
            this.rightIntakeMotor.setPower(0.0);
        }

    }
    public final void halfway(){ this.launchServo.setPosition(0.5); }
    public final void open(){ this.launchServo.setPosition(1.0); }
    public final void close(){ this.launchServo.setPosition(0.0);}

    public void centerFromLeft(double power, boolean isHeld) {
        if (isHeld){ this.leftIntakeMotor.setPower(power);}
        else {this.leftIntakeMotor.setPower(0.0);}
    }

    public void centerFromRight(double power, boolean isHeld) {

        if (isHeld) {this.rightIntakeMotor.setPower(power); }
        else { this.rightIntakeMotor.setPower(0.0); }
    }
    public void activateOuttake(double power) {


        this.leftOuttakeMotor.setPower(power);
        this.rightOuttakeMotor.setPower(power);

        this.open();

    }

    public final void resetOuttake(){

        this.leftOuttakeMotor.setPower(0.0);
        this.rightOuttakeMotor.setPower(0.0);

        this.close();
    }

}
