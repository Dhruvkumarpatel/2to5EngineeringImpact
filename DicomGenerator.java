	/**
     * Function to read dicom file, update the necessary tags and write into a new dicom file. Useful for dataset update, creation in medical imaging development
     * cerner_2^5_2020
     */
	@Test
    public void generateDicomFile()
    {
        final File dcmFolder = new File("C://DICOM//CINE_SKIPPING_TEST//DICOM");
        
        for (for int i=0; i< dcmFolder.listFiles().length; i++)
        {            
            DicomObject dcmObj = null;
            
            try (DicomInputStream inputStream = new DicomInputStream(dcmFolder.listFiles()[i]))
            {
                dcmObj = inputStream.readDicomObject();
                dcmObj.putString(Tag.RecommendedDisplayFrameRate, VR.IS, "60");
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            
            
            final File newFile = new File("C://DICOM//CINE_SKIPPING_MODIFIED//DICOM//dicom"+(i+1)+".dcm");
            DicomOutputStream ds = null;
            
            try (FileOutputStream fs =  new FileOutputStream(newFile);
			DicomOutputStream ds = new DicomOutputStream(new BufferedOutputStream(fs)))
            {
                fs = new FileOutputStream(newFile);
                ds = new DicomOutputStream(new BufferedOutputStream(fs));
                ds.writeDicomFile(dcmObj);
            }
            catch (FileNotFoundException | IOException e)
            {
                e.printStackTrace();
            }
        }
    }