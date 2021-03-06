# Image Slider Sample

## Goal:
- To have a simple way to show a collection of images to slide/rotate through like a banner.

## Application:
- Rotate through a list of images that are retrieved from local file system, or from an API call, or from database (local or online).
- Support for dynamic amounts of images. No hardcoding as we want to be able to add/remove/change the images. The dimensions of the images can be restricted, as it'll probably be weird/ugly to have changing dimensions in a image slider.

## Reference:
- https://www.geeksforgeeks.org/how-to-create-dynamic-auto-image-slider-in-android-with-firebase/
- https://github.com/bumptech/glide
- https://github.com/smarteist/Android-Image-Slider
- https://github.com/smarteist/Android-Image-Slider/issues/109

## Project Notes:
- The project will not work "as-is" as it reads the pictures from <externalStorage/appFolder/> (FileUtils.java).
- The pictures I tested with are phone background images (so portrait images), and the SliderActivity is show the SliderView as full-screen.
- There are much better approaches to this, but this is just for learning/reference.