package org.firstinspires.ftc.teamcode.odometry.control;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;

@Config
public class DriveConstants {
        public static final double TICKS_PER_REV = 1120;
        public static final double MAX_RPM = 150;

        public static final boolean RUN_USING_ENCODER = true;
        public static PIDFCoefficients MOTOR_VELO_PID = new PIDFCoefficients(0, 0, 0,
                getMotorVelocityF(MAX_RPM / 60 * TICKS_PER_REV));
        //TODO: put PID values, order:  P I D F

        public double F = getMotorVelocityF(MAX_RPM / 60 * TICKS_PER_REV);

        public static double WHEEL_RADIUS = 1.4763;
        public static double GEAR_RATIO = 1; // dead wells velocity
        public static double TRACK_WIDTH = 15;

        public static double kV = 1.0 / rpmToVelocity(MAX_RPM);
        public static double kA = 0;
        public static double kStatic = 0; // don't change!

        public static double MAX_VEL = 18.543736; // 80% of max velocity
        public static double MAX_ACCEL = 18.543736;
        public static double MAX_ANG_VEL = Math.toRadians(62.74275);
        public static double MAX_ANG_ACCEL = Math.toRadians(62.74275);

        public static double encoderTicksToInches(double ticks) {
                return WHEEL_RADIUS * 2 * Math.PI * GEAR_RATIO * ticks / TICKS_PER_REV;
        }

        public static double rpmToVelocity(double rpm) {
                return rpm * GEAR_RATIO * 2 * Math.PI * WHEEL_RADIUS / 60.0;
        }

        public static double getMotorVelocityF(double ticksPerSecond) {
                return 32767 / ticksPerSecond;
        }
}
         // max velocity = 23,18967
        // documentation: https://docs.google.com/document/d/1tyWrXDfMidwYyP_5H4mZyVgaEswhOC35gvdmP-V-5hA/edit#heading=h.61g9ixenznbx



