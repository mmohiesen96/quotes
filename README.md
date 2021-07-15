# quotes Application 

<--API-->
Used json parser (Gson library) to parse the json file to a class of type quote and Buffered reader built-in class to read the file from the local machine .
# Quotes Api
**Author**: Mohammed Mohiesen
**Version**: 1.0.1
## Overview
My application will read data from API and respond with a random quote and display it to the user, if offline it will read from
A local JSON file and display a random quote from it .
## Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.
## Prerequisites
- Operating system: Mac OS, Windows, Linux
- Git
  Follow the instruction in the links below to install git in your machine
  - [Windows](https://git-scm.com/download/win)
  - [Mac OS](https://git-scm.com/download/mac)
  - [Linux](https://git-scm.com/download/linux)
- [Codeing Editor](https://www.wpbeginner.com/showcase/12-best-code-editors-for-mac-and-windows-for-editing-wordpress-files/)
## Installation
1. open your terminal
2. Clone the repo
`git clone git@github.com:mmohiesen96/quotes.git`
## Usage
- To use the Application using the IDE Simply run the program and the output will be displayed.
## Architecture
This application was build with Core Java and it includes:
- Class Api to handle Connecting to an API and reading data methods.
- Class ApiQuote to hole the data responded from Api class .
- Class Quote to hold the data read locally .
