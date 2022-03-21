package org.firstinspires.ftc.teamcode.computer_vision.opencv;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;

@TeleOp(name = "OpenCV Setup Webcam", group = "Computer Vision")
public class SetupWebcam extends LinearOpMode {
    int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier(
            "cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());

    public WebcamName robotWebcam = hardwareMap.get(WebcamName.class, "Robot Webcam");
    public OpenCvCamera camera = OpenCvCameraFactory.getInstance().createWebcam(robotWebcam,
            cameraMonitorViewId);
    // ContourPipeline myPipeline;
    /*********************************************************************************************
     * cameraMonitorViewId -                                                                     *
     * robotWebcam -                                                                             *
     * camera -                                                                                  *
     *********************************************************************************************/

    // TODO: Create the first Pipeline

    @Override
    public void runOpMode() {
        camera.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener()
        {
            @Override
            public void onOpened() {
                camera.setViewportRenderer(OpenCvCamera.ViewportRenderer.GPU_ACCELERATED);
                /*
                 * Commonly Supported Resolutions:
                 * 320x240
                 * 640x480
                 * 1280x720
                 * 1920x1080
                 * */
                camera.startStreaming(1280, 720, OpenCvCameraRotation.UPRIGHT);
                // camera.setPipeline(yourPipeline);
            }

            @Override
            public void onError(int errorCode)
            {
                telemetry.addData("Status:", "An error occurred with OpenCV!");
            }
        });

        if (opModeIsActive()) {
            telemetry.addData("Status: ", "Op Mode is Activated");
            while (opModeIsActive()) {
                stopWebcamView();
            }
            telemetry.update();
        }
    }

    public void stopWebcamView() {
        if (gamepad2.y) {
            camera.pauseViewport();
        } else if (gamepad2.a) {
            camera.resumeViewport();
        }
    }
}
