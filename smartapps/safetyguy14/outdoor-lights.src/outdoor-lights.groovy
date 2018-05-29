/**
 *  Outdoor_Lights
 *
 *  Copyright 2018 JOSHUA MASON
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 *
 */
definition(
    name: "Outdoor_Lights",
    namespace: "safetyguy14",
    author: "JOSHUA MASON",
    description: "SmartApp to control outdoor lighting",
    category: "Safety & Security",
    iconUrl: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience.png",
    iconX2Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png",
    iconX3Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png")


preferences {
    page(name: "Devices", title: "Select your Inputs/Outputs", 
         install: true, uninstall: true, hideWhenEmpty: true) {
            section("Motion Sensors") {
            input "motions", "capability.motionSensor", title: "Motion Sensor(s)", multiple: true, required: false
        }
        section("Lights") {
            input "switches", "capability.switch", title: "Light(s)", multiple: true, required: false
        }
        section("Door(s)") {
            //input "garageDoorControls", "capability.garageDoorControl", title: "Garage Door(s)", multiple: true, required: false
            //input "doorControls", "capability.doorControl", title: "Door(s)", multiple: true, required: false
            input "contactSensors", "capability.contactSensor", title: "Misc", multiple: true, required: false
        }
        section("Not Present debounce timer [default=5 minutes]") {
            input "garageQuietThreshold", "number", title: "Time in minutes", required: false
        }
        section("want to turn on mega-debugging?") {
            input "debugMode", "bool", title: "Debug Mode?", required: false
        }
	}
}

def installed() {
	log.debug "Installed with settings: ${settings}"

	initialize()
}

def updated() {
	log.debug "Updated with settings: ${settings}"

	unsubscribe()
	initialize()
}

def initialize() {
	// TODO: subscribe to attributes, devices, locations, etc.
}

// TODO: implement event handlers